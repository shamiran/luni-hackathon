from html.parser import HTMLParser
from urllib.request import urlopen
from urllib import parse

visited = {}

# Handles parsing of a link
class LinkParser(HTMLParser):

    def link_is_absolute(self, url):
        return url[:7] == 'http://' or url[:8] == 'https://'

    def link_is_pdf(self, url):
        return url[-4:] == '.pdf'

    def link_should_be_visited(self, url):
        return ".lu.se/" in url or ".lth.se/" in url

    # Is called when self.feed is called.
    # It is called for every HTML starttag
    def handle_starttag(self, tag, attrs):
        # Only take notice to <a> tags
        if tag == 'a':
            for key, value in attrs:
                # Get href value of <a> tag
                if key == 'href':
                    url = value

                    # Make sure the url is absolute
                    if not self.link_is_absolute(url):
                        url = parse.urljoin(self.baseUrl, url)
                    
                    # Identify is url should be visited or is a pdf
                    if self.link_is_pdf(url):
                        self.links_to_pdfs[url] = True
                    elif self.link_should_be_visited(url):
                        self.links_to_visit.append(url)                    

    def getNewLinksAndPdfs(self, url):

        # Ignore links that has already been visited
        try:
            if visited[url] == True:
                return [], []
        except KeyError:
            pass

        # print("Visiting {}".format(url))

        # Set up variables needed
        self.baseUrl = url
        self.links_to_visit = []
        self.links_to_pdfs = {}

        # Visit the url
        response = urlopen(url)
        visited[url] = True
        content_type = response.getheader('Content-Type')

        # Only care about html documents
        if "text/html" in content_type:
            htmlBytes = response.read()
            htmlString = htmlBytes.decode("utf-8")
            self.feed(htmlString)
            return self.links_to_visit, self.links_to_pdfs
        else:
            return [], {}

class Crawler:        
    
    # Starts crawling
    def crawl(self, start_urls, pdfs_to_find = 100):
        self.links_to_pdfs = {}
        self.links_to_visit = start_urls

        for link in self.links_to_visit:
            try:
                parser = LinkParser()
                new_links, new_pdf_links = parser.getNewLinksAndPdfs(link)
                self.links_to_visit += new_links
                self.links_to_pdfs.update(new_pdf_links)

                # Save all links in every iteration so we do not lose anything incase of crash
                file = open("links_to_pdfs.txt", "w")
                for pdf_link in self.links_to_pdfs:
                    file.write(pdf_link + "\n")

                # Print a status check
                # print("Visited links: {}".format(len(visited)))
                print("PDFs found: {}".format(len(self.links_to_pdfs)))
            except:
                # Catches things such as HTTP 404
                pass
            
            # Break after specified amount of iterations
            # if len(self.links_to_pdfs) > pdfs_to_find:
            #     print("Reached enough PDFs. Will save links to file")
            #     return


crawler = Crawler()

start_urls = [
    "http://cs.lth.se/edan01",
    # "https://kurser.lth.se/lot/?val=program&prog=D"
]
crawler.crawl(start_urls)
from urllib.request import urlretrieve
import string
import random

def random_string(length = 3):
    return ''.join(random.choices(string.ascii_lowercase + string.ascii_uppercase + string.digits, k=length))

def download_file(url):
    splitted_url = url.split('/')
    file_name = "{} - {}".format(random_string(), splitted_url[-1])
    file_name = file_name.strip()
    urlretrieve(url, "pdfs/{}".format(file_name))
    print("Saved {}".format(file_name))

pdf_links = open("links_to_pdfs.txt", "r")

for pdf_link in pdf_links:
    pdf_link = pdf_link.strip()
    download_file(pdf_link)

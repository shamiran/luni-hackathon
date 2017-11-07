import matplotlib.pyplot as plt
import numpy as np

filename = "InfoExtract/histogram_eda16.txt"
with open(filename) as f:
    s = f.read()

v = s.split("\n")
words = list()
occurrences = list()
d = dict()
for x in v:
    x = x.split(";")
    try:
        val = int(x[1])
        if val > 8:
            word = x[0]
            d[word] = val
            occurrences = occurrences + [val]
    except:
        continue
    words = words + [x[0]]

t = np.array(occurrences).astype(int)
X = np.arange(len(d))
plt.bar(X, d.values(), align='center', width=0.5)
plt.xticks(X, d.keys())
ymax = max(d.values()) + 1

plt.ylim(0, ymax)
plt.show()

import csv
from random import random

oFile = open('../Books/book32-listing.csv')
wFile = open('./insert_books.sql','w')
readcsv = csv.reader(oFile, delimiter = ',')

count = 0
for row in readcsv:

    asin = row[0]
    fileno = row[1]
    url = row[2]
    title = row[3]
    author = row[4]
    catid = row[5]
    category = row[6]
    title = title.replace('\'', '\\\'')
    if (random() > 0.3 and random() < 0.5 or category == "Calendars"):
        continue
    if (random() > 0.1):
        wFile.write('INSERT INTO Books(asin, fileName,imageUrl,title,author,categoryId,category) VALUES (\'%s\', \'%s\',\'%s\', \'%s\', \'%s\', %d, \'%s\');\n' % (
            asin, fileno, url, title, author, int(catid), category))
    if (random() > 0.3):
        wFile.write('INSERT INTO Books(asin, fileName,imageUrl,title,author,categoryId,category) VALUES (\'%s\', \'%s\',\'%s\', \'%s\', \'%s\', %d, \'%s\');\n' % (asin,fileno,url,title,author, int(catid),category))
    if (random() > 0.5):
        wFile.write('INSERT INTO Books(asin, fileName,imageUrl,title,author,categoryId,category) VALUES (\'%s\', \'%s\',\'%s\', \'%s\', \'%s\', %d, \'%s\');\n' % (asin, fileno, url, title, author, int(catid), category))
    if (random() > 0.7):
        wFile.write('INSERT INTO Books(asin, fileName,imageUrl,title,author,categoryId,category) VALUES (\'%s\', \'%s\',\'%s\', \'%s\', \'%s\', %d, \'%s\');\n' % (asin, fileno, url, title, author, int(catid), category))
    if (random() > 0.9):
        wFile.write('INSERT INTO Books(asin, fileName,imageUrl,title,author,categoryId,category) VALUES (\'%s\', \'%s\',\'%s\', \'%s\', \'%s\', %d, \'%s\');\n' % (asin, fileno, url, title, author, int(catid), category))
    if (count > 100000):
        break
    count += 1

oFile.close()
wFile.close()

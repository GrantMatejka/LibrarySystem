import csv

oFile = open('./book32-listing.csv')
wFile = open('./insert.sql','w')
readcsv = csv.reader(oFile, delimiter = ',')
for row in readcsv:
    asin = row[0]
    fileno = row[1]
    url = row[2]
    title = row[3]
    author = row[4]
    catid = row[5]
    category = row[6]
    title = title.replace('\'','\\\'')
    wFile.write('INSERT INTO Books(asin, fileName,imageUrl,title,author,categoryId,category) VALUES (\'%s\', \'%s\',\'%s\', \'%s\', \'%s\', %d, \'%s\');\n' % (asin,fileno,url,title,author, int(catid),category))

oFile.close()
wFile.close()


def main():
    line = input()
    l = []
    while line != "--":
        line = line.split(' ')
        l.append("grupos[index++] = new Grupos(" + str(line[3]) + "," + str(line[5]) + "," + str(line[9]) + "," + str(line[7]) + ");")
        line = input()

    for _l in l:
        print(_l)

main()
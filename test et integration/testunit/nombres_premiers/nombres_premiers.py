import sys


def nombres_premiers(a, b):
    return None


if __name__ == "__main__":
    try:
        print(nombres_premiers(int(sys.argv[1]), int(sys.argv[2])))
    except IndexError:
        print("Missing a parameter")

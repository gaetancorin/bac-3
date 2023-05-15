import sys

def volume_cube(edge):
    if not edge:
        raise ValueError("not existing edge parameter")
    if  type(edge) != int and type(edge) != float:
        raise TypeError("Edge need to be a Number")
    if edge < 0:
        raise ValueError("Edge need to be positive value")
    if edge == 0:
        raise ValueError("Edge can't be 0")
    return edge*edge*edge


if __name__ == "__main__":
    try:
        print(volume_cube(int(sys.argv[1])))
    except IndexError:
        print("Missing a parameter")

# python .\volume_cube.py -4
# edge **3

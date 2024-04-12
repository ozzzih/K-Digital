for value in range(6):
    print(value)
numbers = list(range(6))
print(numbers)
numbers1 = set(range(6))
print(numbers1)
squares=[]
for value in range(1,11):
    square = value**2
    squares.append(square)
print(squares)

squares = [value ** 2 for value in range(1,11)]

a=[1,2,3,4]
b=[3,4]
#c=a-b
c=list(set(a)-set(b))
print(c)

players=['A','B','C','D']
for player in players[:3]:
    print(player.title())


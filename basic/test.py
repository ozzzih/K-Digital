#2-3 개별 메시지
name='jihyun'
print(f'안녕하세요. {name}, 오늘 파이썬 배워 보는게 어떨까요?')

#2-4 이름의 대소문자
print(name.upper())
print(name.lower())
print(name.title())

#2-5 명언
print("알베르토 아인슈타인, \"한번도 실수한 적이 없는 사람은 한 번도 새로운 것에 도전해 본 적이 없는 사람이다.\"")

#2-6 명언2
famous_person='알베르토 아인슈타인'
message=f"{famous_person}, \"한번도 실수한 적이 없는 사람은 한 번도 새로운 것에 도전해 본 적이 없는 사람이다.\""
print(message)

#2-7 이름에서 공백 제거
name1='jihyun\t'
print(name1.rstrip())

#2-7
filename='python_notes.txt'
print(filename.removesuffix('.txt'))

#3-4 손님 리스트
invite_list=['aaa','bbb','ccc']
print(f"{invite_list[0]}야, 우리집에 놀러와")
print(f"{invite_list[1]}야, 우리집에 놀러와")
print(f"{invite_list[2]}야, 우리집에 놀러와")

#3-5 손님 리스트 변경
cant='bbb'
print("초대에 응하지 못하는 사람: ",cant)
invite_list[1]='ddd'
print(f"{invite_list[0]}야, 우리집에 놀러와")
print(f"{invite_list[1]}야, 우리집에 놀러와")
print(f"{invite_list[2]}야, 우리집에 놀러와")

#3-6 더 많은 손님
invite_list.insert(0, "eee")
invite_list.insert(int(len(invite_list)), "fff")
invite_list.append("ggg")
for i in range(len(invite_list)):
    print(f"{invite_list[i]}야, 우리집에 놀러와")


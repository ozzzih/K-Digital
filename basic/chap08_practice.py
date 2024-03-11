#8-9 연습문제
sent_messages=[]
def show_message(msg):
    
    for i in msg:
        print(i)
        sent_messages.append(i)
    return sent_messages
    

l=['내일은','휴일', '입니다.']

l1=show_message(l[:])

print(l1)

#8-12 연습문제
def sendwitch(*toppings):
    for topping in toppings:
        print(f"-{topping}")
sendwitch("mushroom", 'green peppers')
sendwitch("mushroom", 'green peppers', 'eextra cheese')

#8-13 연습문제
import user_profile
#user_profile.build_profile()

###map(), filter() 함수 사용
# def power(item):
#     return item*item

# def under_three(item):
#     return item < 3
power = lambda x: x*x
under_three = lambda x:x<3
lst=[1,2,3,4,5]
map_list=map(power, lst)
print(f"map()함수적용결과: {list(map_list)}")
filter_list=filter(under_three, lst)
print(f"filter() 함수 적용 결과: {list(filter_list)}")



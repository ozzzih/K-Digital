def greet_user(username):
    """단순한 인사말 표시"""
    print("Hello!")
    username='kim'
input_name='jesse'
greet_user('jesse')

#print(greet_user.__doc__)

def describe_pet(animal_type, pet_name):
    """반려동물 정보를 표시합니다"""
    print(f"\nI have a {animal_type}.")
    print(f"My {animal_type}'s name is {pet_name.title()}.")
describe_pet('hamster', 'harry')


def get_formatted_name(first_name, last_name, middle_name=''):
    """실제 이름 형식"""
    if middle_name:
        full_name=f"{first_name} {middle_name} {last_name}"
    else:
        full_name = f"{first_name} {last_name}"
    return full_name

a=get_formatted_name('Oh', 'Jihyun', 'asdf')
print(a)

def modify_string(s):
    s="world"


st = "hello "
modify_string(st)
print(st)
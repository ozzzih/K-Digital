print("Hello Python world!")

#2.3.1 메서드를 이용해 대소문자 변경하기
name='ada lovalace'
print(name)
print(name.title()) #첫글자를 대문자
print(name.upper()) #전부다 대문자

#2.3.2 문자열 안에서 변수 사용하기
first_name='ada'
last_name='lovelace'
full_name=f"{first_name} {last_name}"
print(full_name) 
print(f"Hello, {full_name.title()}!")
message = f"Hello, {full_name.title()}!"
print(message)

#2.3.3 탭이나 줄바꿈으로 문자열에 공백 추가하기
print("Python")
print("\tPython")
print("Languages:\n\tPython\n\tC\n\tJavaScript")

#2.3.4 공백 없애기(cmd로 실행해봐야함)
favorite_language = 'python '
favorite_language
favorite_language.rstrip()
favorite_language

#2.3.5 접두사 없애기
nostarch_url = 'https://nostarch.com'
nostarch_url=nostarch_url.removeprefix('https://')
print(nostarch_url)
from flask import Flask, render_template, request
import joblib
from konlpy.tag import Okt
import re

okt=Okt()

# 플라스크 뜰때 같이 뜬느거
model_lr=None
tfidf_vector = None
model_nb=None
dtm_vector=None
app=Flask(__name__)#app.py
app.debug=True

def load_lr():
    global model_lr, tfidf_vector
    model_lr=joblib.load("model/movie_lr.pkl")
    tfidf_vector=joblib.load("model/movie_lr_dtm.pkl")

def load_nb():
    global model_nb, dtm_vector
    model_nb = joblib.load("model/movie_nb.pkl")
    dtm_vector=joblib.laod("model/movie_nb_dtm.pkl")

def tw_tokenizer(text):
    token_ko=okt.morphs(text)
    return token_ko

def lt_t(text):
    review=re.sub(r"\d+", " ", text)
    # text_vector=tfidf_vector([review])
    # return text_vector
    return review
def lt_nb(text):
    stopwords=["은", "는", "이", "가"]
    review=text.replace("[^ㄱ-ㅎㅏ-ㅣ가-힣]", "")
    morphs=okt.morphs(review, stem=True)
    test=" ".join(morph for morph in morphs if not morph in stopwords)
    test_dtm=dtm_vector.transform([test])
    return test_dtm


@app.route("/") #주소창에 루트 실행하면 index실행하는거
def index():
    menu={
        "home":True,
        "senti":False,
    }
    return render_template("home.html", menu=menu) #템플릿을 메뉴랑 렌더링

@app.route("/senti", methods=["GET", "POST"]) 
def senti():
    menu={
        "home":False,
        "senti":True
    }
    if request.method == "GET":
        return render_template("senti.html", menu=menu) 
    else:
        review=request.form["review"]
        review_text=lt_t(review)
        lr_result=model_lr.predict(review_text)[0]
        review_text2=lt_nb(review)
        nb_result=model_lr.predict(review_text)[0]
        lr="긍정" if lr_result else "부정"
        #nb="긍정" if nb_result else "부정"
        movie={"review": review, "lr":lr}

        return render_template("senti_result.html", menu=menu, movie=movie)
         #템플릿을 메뉴랑 렌더링
        #return review

if __name__ =="__main__":
    load_lr()
    load_nb()
    app.run()



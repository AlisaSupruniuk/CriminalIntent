package by.supruniuk.alisa.criminalintent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

//UUID — вспомогательный класс Java, входящий в инфраструктуру Android, —
//предоставляет простой способ генерирования универсально-уникальных идентификаторов.
// В конструкторе такой идентификатор генерируется вызовом UUID.randomUUID().

//Инициализация переменной Date конструктором Date по умолчанию присваивает
//mDate текущую дату. Эта дата станет датой преступления по умолчанию.

public class Crime {

    private UUID mId;
    private String mTitle;
    private String mDate;
    private boolean mSolved;

    public Crime(){
        mId = UUID.randomUUID();
        mDate = new SimpleDateFormat("EEEE, MMM, dd, yyyy").format(new Date());;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

}

package com.monte.carlo

import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.monte.carlo.databinding.ActivityGameBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ActivityGame : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private var ind = 0
    private var a = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.text = qus[ind]
        binding.radioButton.text = ans[ind][0]
        binding.radioButton2.text = ans[ind][1]
        binding.radioButton3.text = ans[ind][2]
        binding.radioButton4.text = ans[ind][3]
        binding.button2.setOnClickListener {
            if(ind>=qus.size) return@setOnClickListener
            var t = 0
            if(binding.radioButton2.isChecked) t = 1
            if(binding.radioButton3.isChecked) t = 2
            if(binding.radioButton4.isChecked) t = 3
            binding.group.clearCheck()
            if(t==tmp[ind]) {
                a++
                Toast.makeText(applicationContext,"Правильный ответ!",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext,"Неправильный ответ!",Toast.LENGTH_SHORT).show()
            }
            ind+=1
            if(ind>=6) {
                startActivity(Intent(applicationContext,EndActivity::class.java).apply {
                    putExtra("count","$a")
                })
                finish()
            }
            binding.textView.text = qus[ind]
            binding.radioButton.text = ans[ind][0]
            binding.radioButton2.text = ans[ind][1]
            binding.radioButton3.text = ans[ind][2]
            binding.radioButton4.text = ans[ind][3]
        }
    }
    val tmp = arrayOf(1,2,2,1,1,3,2)
    val qus = arrayOf(
        "Какой известный учёный был изображён на первом логотипе Apple?",
        "Вопрос о Siri. В какой модели она появилась впервые?",
        "На iPhone можно сделать фото, не касаясь экрана руками. Знаете ли вы этот секретный способ?",
        "iPhone можно пользоваться не только как телефоном. Как вы думаете, какой полезный инструмент он может заменить?",
        "Поговорим о прекрасном. Какой iPhone выбран самым красивым по мнению пользователей Reddit?",
        "Лучше iPhone может быть только классный аксессуар к нему. Что из подобного появилось в этом году?",
        "В большинстве рекламных материалов Apple на iPhone отображается время 9:41. Почему?",
    )
    val ans = arrayOf(
        arrayOf(
            "Альберт Эйнштейн",
            "Исаак Ньютон",
            "Эрвин Шрёдингер",
            "Стивен Хокинг",
        ),
        arrayOf(
            "iPhone 5",
            "iPhone 7",
            "iPhone 4S",
            "iPhone 6 Plus",
        ),

        arrayOf(
            "Легко: нажать на регулятор громкости в подсоединённых наушниках",
            "Можно использовать боковую кнопку увеличения громкости — она тоже делает снимки",
            "Оба варианта с клавишей громкости работают",
            "Крикнуть «Siri, сыр!»",
        ),

        arrayOf(
            "Тепловизор: с его помощью можно видеть тепловую сигнатуру человека, животного или, к примеру, работающей батареи",
            "Строительный уровень: незаменим при ремонте",
            "Мультиметр: проверить напряжение, сопротивление, силу тока…",
            "Весы — можно взвешивать небольшие объекты",
        ),
        arrayOf(
            "iPhone XR в оттенке Space Gray",
            "iPhone 5 в чёрном цвете",
            "Фиолетовый iPhone 12",
            "IPhone 6S цвета «розовое золото»",
        ),
        arrayOf(
            "Фонарик, работающий от USB",
            "Селфи-палка-штатив",
            "Крипто-кошелек",
            "Умная метка",
        ),
        arrayOf(
            "Это любимые числа Стива Джобса",
            "Из-за суеверия: в Apple полагают, что в это время скриншоты выходят идеальными",
            "Именно в это время Стив Джобс представил первый iPhone",
            "Эта пиар-интрига пока не раскрыта",
        ),
    )
}
package com.example.irregularverbs.gateway.realm

import android.util.Log
import com.example.irregularverbs.gateway.VerbGateway
import com.example.irregularverbs.mvp.models.Verb
import io.realm.Realm

class RealmVerbGateway : VerbGateway { //TODO DAGGER + APPLICATION +++++++ USE  FRAGMENTS INSTEAD ACTIVITIES

    private val verbList = ArrayList<Verb>()

    companion object {
        private const val TAG = "RealmVerbGateway"
        const val TAG_LEVEL = "level"
    }

    private fun initVerbs() { //TODO MOVE TO RESOURCE
        verbList.add(Verb("arise", "arose", "arisen", 1, "возникать"))
        verbList.add(Verb("awake", "awoke", "awoken", 1, "пробуждаться"))
        verbList.add(Verb("be", "was", "been", 1, "быть"))
        verbList.add(Verb("bear", "bore", "born", 1, "родиться"))
        verbList.add(Verb("beat", "beat", "beaten", 1, "бить"))
        verbList.add(Verb("become", "became", "become", 1, "становиться"))
        verbList.add(Verb("befall", "befell", "befallen", 1, "приключаться"))
        verbList.add(Verb("beget", "begot", "begot", 1, "вызывать, порождать"))
        verbList.add(Verb("begin", "began", "begun", 1, "начинать"))
        verbList.add(Verb("behold", "beheld", "beheld", 1, "увидеть, узреть"))
        verbList.add(Verb("bend", "bent", "bent", 1, "сгибать"))
        verbList.add(Verb("beseech", "beseech", "beseech", 1, "просить, умолять"))
        verbList.add(Verb("beset", "beset", "beset", 1, "осаждать, окружать"))
        verbList.add(Verb("bestride", "bestrode", "bestridden", 1, "садиться, сидеть верхом"))
        verbList.add(Verb("bet", "bet", "bet", 1, "держать пари, быть уверенным"))
        verbList.add(Verb("bid", "bid", "bid", 1, "предлагать цену (обычно на аукционе)"))
        verbList.add(Verb("bind", "bound", "bound", 1, "вязать, связывать"))
        verbList.add(Verb("bite", "bit", "bitten", 1, "кусать"))
        verbList.add(Verb("bleed", "bled", "bled", 1, "кровоточить"))
        verbList.add(Verb("bless", "blessed", "blessed", 1, "благословлять"))
        verbList.add(Verb("blow", "blew", "blown", 1, "дуть"))
        verbList.add(Verb("break", "broke", "broken", 1, "ломать"))
        verbList.add(Verb("breed", "bred", "bred", 1, "размножать, порождать"))
        verbList.add(Verb("bring", "brought", "brought", 1, "приносить"))
        verbList.add(Verb("broadcast", "broadcast", "broadcast", 1, "транслировать"))
        verbList.add(Verb("browbeat", "browbeat", "browbeaten", 1, "запугивать"))
        verbList.add(Verb("build", "built", "built", 1, "строить"))
        verbList.add(Verb("burn", "burnt", "burnt", 1, "гореть, жечь"))
        verbList.add(Verb("burst", "burst", "burst", 1, "взрываться"))
        verbList.add(Verb("bust", "bust", "bust", 1, "сломать, разрушать"))
        verbList.add(Verb("buy", "bought", "bought", 1, "покупать"))
        verbList.add(Verb("cast", "cast", "cast", 1, "бросать, кидать"))
        verbList.add(Verb("catch", "caught", "caught", 1, "ловить"))
        verbList.add(Verb("choose", "chose", "chosen", 1, "выбирать"))
        verbList.add(Verb("cleave", "cleave", "cloven", 1, "раскалывать"))
        verbList.add(Verb("cling", "clung", "clung", 1, "цепляться"))
        verbList.add(Verb("come", "came", "come", 1, "приходить"))
        verbList.add(Verb("cost", "cost", "cost", 1, "стоить"))
        verbList.add(Verb("creep", "crept", "crept", 1, "ползать, красться"))
        verbList.add(Verb("cut", "cut", "cut", 1, "резать"))
        verbList.add(Verb("deal", "dealt", "dealt", 1, "иметь дело"))
        verbList.add(Verb("dig", "dug", "dug", 1, "копать"))
        verbList.add(Verb("do", "did", "done", 1, "делать"))
        verbList.add(Verb("draw", "drew", "drawn", 1, "рисовать"))
        verbList.add(Verb("dream", "dreamt", "dreamt", 1, "мечтать"))
        verbList.add(Verb("drink", "drank", "drunk", 1, "пить"))
        verbList.add(Verb("drive", "drove", "driven", 1, "вести машину"))
        verbList.add(Verb("dwell", "dwelt", "dwelt", 1, "подробно останавливаться (на чем-то)"))
        verbList.add(Verb("eat", "ate", "eaten", 2, "есть"))
        verbList.add(Verb("fall", "fell", "fallen", 2, "падать"))
        verbList.add(Verb("feed", "fed", "fed", 2, "кормить"))
        verbList.add(Verb("feel", "felt", "felt", 2, "чувствовать"))
        verbList.add(Verb("fight", "fought", "fought", 2, "драться, бороться"))
        verbList.add(Verb("find", "found", "found", 2, "находить"))
        verbList.add(Verb("fit", "fit", "fit", 2, "быть  в пору, подходить"))
        verbList.add(Verb("flee", "fled", "fled", 2, "убегать, спасаться бегством"))
        verbList.add(Verb("fling", "flung", "flung", 2, "бросать, кидать"))
        verbList.add(Verb("fly", "flew", "flown", 2, "летать"))
        verbList.add(Verb("forbear", "forbore", "forborne", 2, "воздерживаться"))
        verbList.add(Verb("forbid", "forbade", "forbidden", 2, "запрещать"))
        verbList.add(Verb("forecast", "forecast", "forecast", 2, "предсказывать"))
        verbList.add(Verb("foresee", "foresaw", "foreseen", 2, "предвидеть"))
        verbList.add(Verb("foretell", "foretold", "foretold", 2, "предсказывать"))
        verbList.add(Verb("forget", "forgot", "forgotten", 2, "забывать"))
        verbList.add(Verb("forgive", "forgave", "forgiven", 2, "прощать"))
        verbList.add(Verb("forsake", "forsook", "forsaken", 2, "оставлять, покидать"))
        verbList.add(Verb("forswear", "forswore", "foresworn", 2, "отказываться, отрекаться"))
        verbList.add(Verb("freeze", "froze", "frozen", 2, "замерзать"))
        verbList.add(Verb("gainsay", "gainsaid", "gainsaid", 2, "отрицать, возражать"))
        verbList.add(Verb("get", "got", "got", 2, "получать"))
        verbList.add(Verb("gird", "girt", "girt", 2, "опоясывать, подпоясываться"))
        verbList.add(Verb("give", "gave", "given", 2, "давать"))
        verbList.add(Verb("go", "went", "gone", 2, "идти"))
        verbList.add(Verb("grind", "ground", "ground", 2, "молоть"))
        verbList.add(Verb("grow", "grew", "grown", 2, "расти"))
        verbList.add(Verb("hang", "hung", "hung", 2, "вешать"))
        verbList.add(Verb("have", "had", "had", 2, "иметь"))
        verbList.add(Verb("hew", "hewed", "hewed", 2, "разрубать рассекать"))
        verbList.add(Verb("hear", "heard", "heard", 2, "слышать"))
        verbList.add(Verb("hide", "hid", "hidden", 2, "прятаться"))
        verbList.add(Verb("hit", "hit", "hit", 2, "ударять"))
        verbList.add(Verb("hold", "held", "held", 2, "держать"))
        verbList.add(Verb("hurt", "hurt", "hurt", 2, "повредить, ушибить"))
        verbList.add(Verb("input", "input", "input", 2, "вводить (в компьютер)"))
        verbList.add(Verb("inset", "inset", "inset", 2, "вставлять, вкладывать"))
        verbList.add(Verb("interweave", "interwove", "interwoven", 2, "переплетать, сплетать"))
        verbList.add(Verb("keep", "kept", "kept", 2, "держать"))
        verbList.add(Verb("kneel", "knelt", "knelt", 2, "стоять на коленях"))
        verbList.add(Verb("knit", "knit", "knit", 2, "вязать"))
        verbList.add(Verb("know", "knew", "known", 2, "знать"))
        verbList.add(Verb("lay", "laid", "laid", 2, "класть"))
        verbList.add(Verb("lean", "leant", "leant", 2, "наклоняться, прислоняться"))
        verbList.add(Verb("lead", "led", "led", 2, "вести"))
        verbList.add(Verb("learn", "learnt", "learnt", 2, "учить (что-либо)"))
        verbList.add(Verb("leap", "leapt", "leapt", 2, "прыгать"))
        verbList.add(Verb("leave", "left", "left", 2, "оставлять"))
        verbList.add(Verb("lend", "lent", "lent", 2, "одалживать"))
        verbList.add(Verb("let", "let", "let", 2, "позволять"))
        verbList.add(Verb("lie", "lay", "lain", 2, "лежать"))
        verbList.add(Verb("light", "lit", "lit", 2, "освещать, зажигать"))
        verbList.add(Verb("lose", "lost", "lost", 2, "терять"))
        verbList.add(Verb("make", "made", "made", 3, "делать"))
        verbList.add(Verb("mean", "meant", "meant", 3, "иметь в виду, намереваться"))
        verbList.add(Verb("meet", "met", "met", 3, "встречать"))
        verbList.add(Verb("miscast", "miscast", "miscast", 3, "дать неподходящую роль"))
        verbList.add(Verb("mishear", "misheard", "misheard", 3, "ослышаться"))
        verbList.add(Verb("mishit", "mishit", "mishit", 3, "промахнуться"))
        verbList.add(Verb("mislay", "mislaid", "mislaid", 3, "положить не на место"))
        verbList.add(Verb("mislead", "misled", "misled", 3, "вводить в заблуждение"))
        verbList.add(Verb("misread", "misread", "misread", 3, "прочитать неправильно"))
        verbList.add(Verb("misspell", "misspelt", "misspelt", 3, "писать с орфографическими ошибками"))
        verbList.add(Verb("misspend", "misspent", "misspent", 3, "неразумно, зря тратить"))
        verbList.add(Verb("mistake", "mistook", "mistaken", 3, "ошибаться"))
        verbList.add(Verb("misunderstand", "misunderstood", "misunderstood", 3, "неправильно понять"))
        verbList.add(Verb("mow", "mowed", "mowed", 3, "косить"))
        verbList.add(Verb("outbid", "outbid", "outbid", 3, "перебивать цену"))
        verbList.add(Verb("outdo", "outdid", "outdone", 3, "превзойти"))
        verbList.add(Verb("outgrow", "outgrew", "outgrown", 3, "перерастать, вырастать"))
        verbList.add(Verb("output", "output", "output", 3, "выпускать, выводить (данные)"))
        verbList.add(Verb("outrun", "outran", "outrun", 3, "перегонять, опережать"))
        verbList.add(Verb("outsell", "outsold", "outsold", 3, "продаваться лучше"))
        verbList.add(Verb("outshine", "outshone", "outshone", 3, "затмить"))
        verbList.add(Verb("overbid", "overbid", "overbid", 3, "перебивать цену"))
        verbList.add(Verb("overcome", "overcame", "overcome", 3, "преодолевать, побороть"))
        verbList.add(Verb("overdo", "overdid", "overdone", 3, "перестараться"))
        verbList.add(Verb("overeat", "overate", "overeaten", 3, "объедаться, передать"))
        verbList.add(Verb("overfly", "overflew", "overflown", 3, "перелетать"))
        verbList.add(Verb("overhang", "overhung", "overhung", 3, "нависать"))
        verbList.add(Verb("overhear", "overheard", "overheard", 3, "подслушивать"))
        verbList.add(Verb("overlay", "overlaid", "overlaid", 3, "покрывать"))
        verbList.add(Verb("overpay", "overpaid", "overpaid", 3, "переплачивать"))
        verbList.add(Verb("override", "overrode", "overridden", 3, "отменять, перевешивать"))
        verbList.add(Verb("overrun", "overran", "overrun", 3, "переходить пределы, границы"))
        verbList.add(Verb("oversee", "oversaw", "overseen", 3, "наблюдать, надзирать"))
        verbList.add(Verb("overshoot", "overshot", "overshot", 3, "промахнуться"))
        verbList.add(Verb("oversleep", "overslept", "overslept", 3, "проспать"))
        verbList.add(Verb("overtake", "overtook", "overtaken", 3, "обогнать, овладевать"))
        verbList.add(Verb("overthrow", "overthrew", "overthrown", 3, "перебрасывать, свергать"))
        verbList.add(Verb("partake", "partook", "partaken", 3, "принимать участие"))
        verbList.add(Verb("pay", "paid", "paid", 3, "платить"))
        verbList.add(Verb("prepay", "prepaid", "prepaid", 3, "платить вперёд"))
        verbList.add(Verb("prove", "proved", "proved", 3, "доказывать"))
        verbList.add(Verb("put", "put", "put", 3, "класть"))
        verbList.add(Verb("quit", "quit", "quit", 3, "оставлять, покидать"))
        verbList.add(Verb("read", "read", "read", 3, "читать"))
        verbList.add(Verb("rebuild", "rebuilt", "rebuilt", 3, "отстроить заново, реконструировать"))
        verbList.add(Verb("recast", "recast", "recast", 3, "переделывать, изменять"))
        verbList.add(Verb("redo", "redid", "redone", 3, "делать вновь, переделывать"))
        verbList.add(Verb("remake", "remade", "remade", 3, "переделать"))
        verbList.add(Verb("rend", "rent", "rent", 3, "раздирать на куски"))
        verbList.add(Verb("repay", "repaid", "repaid", 3, "выплатить"))
        verbList.add(Verb("rerun", "reran", "rerun", 3, "повторно показывать"))
        verbList.add(Verb("resell", "resold", "resold", 3, "перепродавать"))
        verbList.add(Verb("reset", "reset", "reset", 3, "вновь устанавливать, сбрасывать"))
        verbList.add(Verb("resit", "resat", "resat", 3, "пересдавать"))
        verbList.add(Verb("retake", "retook", "retaken", 3, "пересдавать экзамен"))
        verbList.add(Verb("retell", "retold", "retold", 3, "пересказывать"))
        verbList.add(Verb("rewrite", "rewrote", "rewritten", 3, "переписать"))
        verbList.add(Verb("ride", "rode", "ridden", 3, "ездить верхом"))
        verbList.add(Verb("ring", "rung", "rung", 3, "звонить"))
        verbList.add(Verb("rise", "rose", "risen", 3, "подниматься"))
        verbList.add(Verb("run", "ran", "run", 3, "бежать"))
        verbList.add(Verb("saw", "sawed", "sawn", 4, "пилить"))
        verbList.add(Verb("say", "said", "said", 4, "говорить"))
        verbList.add(Verb("see", "saw", "seen", 4, "видеть"))
        verbList.add(Verb("seek", "sought", "sought", 4, "искать"))
        verbList.add(Verb("sell", "sold", "sold", 4, "продавать"))
        verbList.add(Verb("send", "sent", "sent", 4, "отправлять"))
        verbList.add(Verb("set", "set", "set", 4, "ставить, устанавливать"))
        verbList.add(Verb("sew", "sewed", "sewn", 4, "шить"))
        verbList.add(Verb("shake", "shook", "shaken", 4, "трясти"))
        verbList.add(Verb("shear", "sheared", "sheared", 4, "стричь"))
        verbList.add(Verb("shed", "shed", "shed", 4, "проливать"))
        verbList.add(Verb("shine", "shone", "shone", 4, "светить, сиять"))
        verbList.add(Verb("shoe", "shod", "shod", 4, "обувать, подковывать"))
        verbList.add(Verb("shoot", "shot", "shot", 4, "стрелять"))
        verbList.add(Verb("show", "showed", "shown", 4, "показывать"))
        verbList.add(Verb("shrink", "shrank", "shrunk", 4, "сокращаться, сжиматься"))
        verbList.add(Verb("shut", "shut", "shut", 4, "закрывать"))
        verbList.add(Verb("sing", "sang", "sung", 4, "петь"))
        verbList.add(Verb("sink", "sank", "sunk", 4, "тонуть, погружаться"))
        verbList.add(Verb("sit", "sat", "sat", 4, "сидеть"))
        verbList.add(Verb("slay", "slew", "slain", 4, "убивать, уничтожать"))
        verbList.add(Verb("sleep", "slept", "slept", 4, "спать"))
        verbList.add(Verb("slide", "slid", "slid", 4, "скользить"))
        verbList.add(Verb("sling", "slung", "slung", 4, "бросать, швырять"))
        verbList.add(Verb("slink", "slunk", "slunk", 4, "красться"))
        verbList.add(Verb("slit", "slit", "slit", 4, "рвать"))
        verbList.add(Verb("smell", "smelt", "smelt", 4, "чувствовать запах, нюхать"))
        verbList.add(Verb("smite", "smote", "smitten", 4, "ударять, бить"))
        verbList.add(Verb("sow", "sowed", "sown", 4, "сеять"))
        verbList.add(Verb("speak", "spoke", "spoken", 4, "говорить"))
        verbList.add(Verb("speed", "sped", "sped", 4, "мчаться, спешить"))
        verbList.add(Verb("spend", "spent", "spent", 4, "тратить"))
        verbList.add(Verb("spell", "spelt", "spelt", 4, "писать или произносить по буквам"))
        verbList.add(Verb("spill", "spilt", "spilt", 4, "проливать"))
        verbList.add(Verb("spin", "spun", "spun", 4, "прясть, оборачиваться"))
        verbList.add(Verb("spit", "spat", "spat", 4, "плевать"))
        verbList.add(Verb("split", "split", "split", 4, "расколоть, разбить"))
        verbList.add(Verb("spoil", "spoilt", "spoilt", 4, "портить"))
        verbList.add(Verb("spotlight", "spotlit", "spotlit", 4, "осветить"))
        verbList.add(Verb("spread", "spread", "spread", 4, "распространяться"))
        verbList.add(Verb("spring", "sprang", "sprung", 4, "бросаться, возникнуть"))
        verbList.add(Verb("stand", "stood", "stood", 4, "стоять"))
        verbList.add(Verb("stick", "stuck", "stuck", 4, "приклеивать, сдержаться"))
        verbList.add(Verb("sting", "stung", "stung", 4, "жалить"))
        verbList.add(Verb("stink", "stank", "stunk", 4, "вонять"))
        verbList.add(Verb("steal", "stole", "stolen", 4, "красть"))
        verbList.add(Verb("strew", "strewed", "strewn", 4, "разбрасывать"))
        verbList.add(Verb("stride", "strode", "stridden", 4, "шагать"))
        verbList.add(Verb("strike", "struck", "struck", 4, "ударять, бить"))
        verbList.add(Verb("string", "strung", "strung", 4, "натягивать, нанизывать"))
        verbList.add(Verb("strive", "strove", "striven", 4, "стараться"))
        verbList.add(Verb("sublet", "sublet", "sublet", 4, "сдавать в субаренду"))
        verbList.add(Verb("swear", "swore", "sworn", 4, "клясться, ругаться"))
        verbList.add(Verb("sweep", "swept", "swept", 4, "подметать, мчаться"))
        verbList.add(Verb("swell", "swelled", "swollen", 4, "разбухать"))
        verbList.add(Verb("swim", "swam", "swum", 4, "плавать"))
        verbList.add(Verb("swing", "swung", "swung", 4, "качаться, вертеться"))
        verbList.add(Verb("take", "took", "taken", 5, "брать"))
        verbList.add(Verb("teach", "taught", "taught", 5, "обучать"))
        verbList.add(Verb("tear", "tore", "torn", 5, "рвать"))
        verbList.add(Verb("tell", "told", "told", 5, "сказать"))
        verbList.add(Verb("think", "thought", "thought", 5, "думать"))
        verbList.add(Verb("thrive", "throve", "thriven", 5, "преуспевать, процветать"))
        verbList.add(Verb("throw", "threw", "thrown", 5, "бросать"))
        verbList.add(Verb("thrust", "thrust", "thrust", 5, "толкать, засовывать"))
        verbList.add(Verb("tread", "trod", "trodden", 5, "ступать, наступать"))
        verbList.add(Verb("unbend", "unbent", "unbent", 5, "выпрямляться, разгибаться"))
        verbList.add(Verb("undercut", "undercut", "undercut", 5, "подрезать, сбивать цены"))
        verbList.add(Verb("undergo", "underwent", "undergone", 5, "испытывать, подвергаться"))
        verbList.add(Verb("underlie", "underlay", "underlain", 5, "лежать в основе"))
        verbList.add(Verb("underpay", "underpaid", "underpaid", 5, "недоплачивать"))
        verbList.add(Verb("undersell", "undersold", "undersold", 5, "продавать дешевле"))
        verbList.add(Verb("understand", "understood", "understood", 5, "понимать"))
        verbList.add(Verb("underwrite", "underwrote", "underwritten", 5, "подписывать, гарантировать"))
        verbList.add(Verb("undertake", "undertook", "undertaken", 5, "предпринимать, совершать"))
        verbList.add(Verb("undo", "undid", "undone", 5, "расстёгивать, развязывать"))
        verbList.add(Verb("unwind", "unwound", "unwound", 5, "разматывать"))
        verbList.add(Verb("uphold", "upheld", "upheld", 5, "поддерживать, одобрять"))
        verbList.add(Verb("upset", "upset", "upset", 5, "опрокидывать, расстраивать"))
        verbList.add(Verb("wake", "woke", "woken", 5, "просыпаться, будить"))
        verbList.add(Verb("waylay", "waylaid", "waylaid", 5, "подстерегать"))
        verbList.add(Verb("wear", "wore", "worn", 5, "носить (одежду)"))
        verbList.add(Verb("weave", "wove", "woven", 5, "ткать, плести"))
        verbList.add(Verb("wed", "wed", "wed", 5, "жениться, выходить замуж"))
        verbList.add(Verb("weep", "wept", "wept", 5, "плакать"))
        verbList.add(Verb("wet", "wet", "wet", 5, "мочить, смачивать"))
        verbList.add(Verb("win", "won", "won", 5, "выигрывать"))
        verbList.add(Verb("wind", "wound", "wound", 5, "обматывать, заводить (часы)"))
        verbList.add(Verb("withdraw", "withdrew", "withdrawn", 5, "взять назад"))
        verbList.add(Verb("withhold", "withheld", "withheld", 5, "воздерживаться, удерживать"))
        verbList.add(Verb("withstand", "withstood", "withstood", 5, "выдержать, противостоять"))
        verbList.add(Verb("wring", "wrung", "wrung", 5, "крутить, жать"))
        verbList.add(Verb("write", "wrote", "written", 5, "писать"))
    }

    override fun saveVerbs() {
        initVerbs()
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.insert(verbList)
        realm.commitTransaction()
    }

    override fun changeAmountOfAnswers(currentVerb: Verb) {
        Realm.getDefaultInstance().executeTransaction { realm ->
            val verb = realm.where(Verb::class.java)
                .equalTo("firstForm", currentVerb.firstForm)
                .findFirst()

            verb!!.amountOfCorrectAnswers++
        }
    }

    override fun changeAmountOfMistakes(currentVerb: Verb) {
        Realm.getDefaultInstance().executeTransaction { realm ->
            val verb = realm.where(Verb::class.java)
                .equalTo("firstForm", currentVerb.firstForm)
                .findFirst()

            verb!!.amountOfMistakes++
        }
    }

    override fun loadVerbs(level: Int?): ArrayList<Verb> {
        if (verbList.size == 0) {
            Realm.getDefaultInstance().executeTransaction { realm ->
                val verbs = realm.where(Verb::class.java).findAll()
                verbs.forEach { verb ->
                    verbList.add(verb)
                }
            }
        }
        return loadChosenVerbs(level)
    }

    override fun deleteLevelProgress(level: Int) {
        Realm.getDefaultInstance().executeTransaction { realm ->
            val verbs = realm.where(Verb::class.java).equalTo(TAG_LEVEL, level).findAll()
            verbs.forEach {
                it.amountOfCorrectAnswers = 0
                it.amountOfMistakes = 0
            }
        }
    }

    override fun resetAllProgress() {
        Realm.getDefaultInstance().executeTransaction { realm ->
            val verbs = realm.where(Verb::class.java).findAll()
            verbs.forEach {
                it.amountOfCorrectAnswers = 0
                it.amountOfMistakes = 0
            }
        }
    }

    override fun loadTooBadVerbs(): ArrayList<Verb> {
        val verbs = ArrayList<Verb>()
        Realm.getDefaultInstance().executeTransaction { realm ->
            val result = realm.where(Verb::class.java)
                .lessThan("amountOfCorrectAnswers", 3)
                .greaterThan("amountOfMistakes", 4)
                .findAll()
            result.forEach { verb ->
                verbs.add(verb)
            }
        }
        return verbs
    }

    override fun loadSoSoBVerbs(): ArrayList<Verb> {
        val verbs = ArrayList<Verb>()
        Realm.getDefaultInstance().executeTransaction { realm ->
            val result = realm.where(Verb::class.java)
                .between("amountOfCorrectAnswers", 3, 5)
                .greaterThan("amountOfMistakes", 2)
                .findAll()
            result.forEach { verb ->
                verbs.add(verb)
            }
        }
        return verbs
    }

    override fun loadExactlyKnownVerbs(): ArrayList<Verb> {
        val verbs = ArrayList<Verb>()
        Realm.getDefaultInstance().executeTransaction { realm ->
            val result = realm.where(Verb::class.java)
                .greaterThan("amountOfCorrectAnswers", 3)
                .lessThan("amountOfMistakes", 3)
                .or()
                .greaterThan("amountOfCorrectAnswers", 5)
                .findAll()
            result.forEach { verb ->
                verbs.add(verb)
            }
        }
        return verbs
    }

    override fun getAmountOfRightAnswers(): Int {
        var amountOfRightAnswers = 0
        Realm.getDefaultInstance().executeTransaction { realm ->
            val result = realm.where(Verb::class.java).findAll()
            result.forEach {
                amountOfRightAnswers += it.amountOfCorrectAnswers
            }
        }
        return amountOfRightAnswers
    }

    override fun getAmountOfWrongAnswers(): Int {
        var amountOfWrongAnswers = 0
        Realm.getDefaultInstance().executeTransaction { realm ->
            val result = realm.where(Verb::class.java).findAll()
            result.forEach {
                amountOfWrongAnswers += it.amountOfMistakes
            }
        }
        return amountOfWrongAnswers
    }

    private fun loadChosenVerbs(level: Int?): ArrayList<Verb> {
        var sortedList = ArrayList<Verb>()
        if (level == null) {
            sortedList = verbList
            return sortedList
        }
        for (verb in verbList) {
            if (verb.level == level) {
                sortedList.add(verb)
            }
        }
        Log.d(TAG, "loadChosenVerbs: ${sortedList.size}")
        return sortedList
    }
}
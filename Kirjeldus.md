# veeArvesti
Digitaalne veearvesti
Projekti autorid: Peeter Liik, Janeli Õun



Väike kasutussoovitus:
* Et testida programmi nii viisil, kui pole viimase kuu näite sisestad, kui ka viisil kui need on olemas, tegime näitude algfaili ilma viimase kuu infota. Kui tahate uuesti 0-st alustada, saab "näidud reset.txt" faili abil luua uue puhta "näidud.txt" faili.



Projekti lühiülevaade:
* Projekti lõppeesmärk on muuta traditsiooniline analoogne veearvesti automatiseerimise teel digitaalseks. Antud aine raames on projekti eesmärgiks valmis teha tarkvaralahendus, mis võimaldaks tuvastada pildi pealt kvaliteetselt ja vigadeta veenäidu. 
* Programm peab olema lisaks suuteline regulaarse vahega saabuvad veenäidud talletama massiividesse ning
tegema vajalikud arvutused, mis oleksid aluseks veenäitude dashboardile. 
* Lisaks peab programm olema suuteline automaatselt veenäite edastama e-maili kujul ette antud aadressile.
* Projekti skoopi mahub pildituvastus ja andmete töötlemine, lihtsa graafilise liidese teostus ja veenäitude edastamine. 
* Projekti riistvaraline pool (arvuti ja kaamera, mis regulaarse intervalliga veenäite pildistab) jäävad väljapoole antud aine raamidest.
* Projektis kasutatakse numbrite pildist tuvastamiseks OCR (Optical Character Recognizition) eelvalmistatud Java teeki Tesseract.



Klassid (2. rühmatöö skoop):
* Peaklass (jätsime alles 1. versiooni ka, vajadusel testimiseks)
* PeaklassGraafiline (2. rühmatöö skoop: Graafiline peaklass testimiseks)
* Tuvastus (Tesseract sümbolituvastus)
* NäidudMassiivi (Loeb automaatselt sisestatud või manuaalselt lisatud näidud sisse, paneb tekstifaili koos vastava aasta ja kuuga, saadab ka meilile)
* MassiiviStatistika (Kuvab näitusid statistliseks töötluseks sobivas vormis, arvutab hinda)



Protsessi kirjeldus ja panus:
* Programm sündis Peetri reaalsest vajadusest inspireeritud huvist, kuidas oleks võimalik lihtsat kuid tüütut igakuist tööd automatiseerida. Rühmakaaslaseks leidis ta Slacki kuulutuse pannes Janeli, kellele idee väga huvi pakkus.
* Koostöö sujus meeldivalt. Peeter sättis üles dokumendi leitud Tessaracti teegiga ning koos hakati testima ja vajalikke klasse lisama ja täiendama. Kuna Janeli Mac ei saa Tessaractiga hakkama, oli väga tervitatav erindite õppimisel tekkinud sellest tulenevate errorite möödahiilimise võimalus. 
* Võib öelda, et enamasti töötasime projekti kallal võrdselt, Tessaractiga tegeles pigem Peeter, mille jagu Janeli proovis rohkem lõppvisuaali ja kasutajakogemust lihvida. Mõlemal läks projektile kokku kuskil nädala jagu õhtuti töötamise aega.



Tegemise mured:
* Projekti puhul töötab Tuvastuse klass hetkel ainult väga selgete kontrasete piltidega. Näidete hulgas on üks selline (vesi1.jpg), teised pildid annavad hetkel veateate. Tuvastus ei pruugi töötada Mac OSis, kuid teiste funktsionaalsuste tööd saab siiski tänu erinditele ka siis demonstreerida.
* Meiliedastuse tööle saamine võttis kõvasti pusimist erinevate juhendite järgi, kuni lõpuks GMaili õigete settingute ja heade juhiste kooslusel oli võimalik Java kaudu meilikontole sisse logida. Aga kahe rühmatöö etapi vahel oli juba mingid uued settingud lisatud, mis tuli üles leida, mille jaoks oli vaja nende muutmiseks täpselt URLi teada.
* JavaFX ei saanud kasutada, kuna see kasutab Gradlet ja meil läheb senise töö jaoks Mavenit vaja, nende kokkuliitmine tundus keerukam, kui vahetada graafilise liidese tööriista. Läksime Java Swingi peale üle, üpris viimasel hetkel, mistõttu ei ole sealt ehk kavalamaid lahendusi kasutanud.
* Kokkuvõttes jääb lihtsalt puudu vabast ajast, et projekti edasi lihvida ja rohkem ja kasulikumat statistikat visuaalselt põnevamalt esitada.



Hinnang:
* Oleme väga uhked oma programmi üle - poleks veel mõned kuud tagasi kujutanud ettegi, et midagi sellist teha saame.
* Arvame, et saime hoolimata harjumuspäratust graafilise liidese tööriistast väga hästi oma visuaalse UI-ga hakkama.
* Saime päriselt programmi pildilt teksti lugema!
* Saime hakkama programmi kaudu e-mailile logimise ja sealt kirja saatmisega!
* Arendamist vajab veel IDE ja dependencyte ja teekide koostöö ja seoste mõistmine, et leiaksime lihtsamalt probleeme, mis tuleb väliste vahendite kasutamisel oma IDEga.
* Arendamist vajab veel ka pilditöötlusoskused: ehk ühel päeval suudaks fotod automaatselt ka programmiga õigeks lõigata ja värvid kontrastseks keerata.



Kuidas testisime:
* Tegime alguses mittegraafilise peaklassi, kuhu lõime näidissisu, millega erinevaid meetodeid katsetada. Selleks aitas meid nii failidest lugemine kui ka meetodite ülekirjutamine, et ise vahepealseid "tükke" manuaalselt lisada.
* Kui tekkis probleem Macis programmi osa tööga, testisime mitmes erinevas seadmes, et tuvastada probleemi allikas. Tuli välja et Windowsi masinates töötab.


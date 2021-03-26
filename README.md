# veeArvesti
Digitaalne veearvesti
Projekti autorid: Peeter Liik, Janeli Õun

Projekti lühiülevaade:
Projekti lõppeesmärk on muuta traditsiooniline analoogne veearvesti automatiseerimise teel digitaalseks. Antud aine raames on projekti eesmärgiks valmis teha tarkvaralahendus,
mis võimaldaks tuvastada pildi pealt kvaliteetselt ja vigadeta veenäidu. Programm peab olema lisaks suuteline regulaarse vahega saabuvad veenäidud talletama massiividesse ning
tegema vajalikud arvutused, mis oleksid aluseks veenäitude dashboardile. Lisaks peab programm olema suuteline automaatselt veenäite edastama e-maili kujul ette antud aadressile.
Esimese projekti skoopi mahub pildituvastus ja andmete töötlemine. Dashboardi teostus ja veenäitude edastamine on plaanis võimalikult suures mahus ellu viia antud aine teise
rühmatöö raames. Projekti riistvaraline pool (arvuti ja kaamera, mis regulaarse intervalliga veenäite pildistab) jäävad väljapoole antud aine raamidest.

Projektis kasutatakse numbrite pildist tuvastamiseks OCR (Optical Character Recognizition) eelvalmistatud Java teeki Tesseract.

Klassid (1. rühmatöö skoop)
Peaklass (testimiseks)
Sümbolituvastus (Tesseract)
NäidudMassiivi
MassiiviStatistika

Projekti puhul töötab Tuvastuse klass hetkel ainult väga selgete kontrasete piltidega. Näidete hulgas on üks selline (vesi1.jpg), teised pildid annavad hetkel veateate.

Projekt suudab lugeda näidud massiivi, need statistilisel kujul esitada ning lisaks saata näidud ka soovitud e-mailile.


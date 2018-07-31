function menseki(hankei,ensyuritu=3.14){
	return hankei*hankei*ensyuritu;
}

document.write(menseki(5)+"<br>");
document.write(menseki(7)+"<br>");
document.write(menseki(10)+"<br>");

document.write("<br>");
document.write("<br>");


function goukei(group,otona,kodomo){
	return group+"グループの合計金額は"+(otona*500+kodomo*200)+"円です。";
}

document.write(goukei("A",2,4)+"<br>");
document.write(goukei("B",1,5)+"<br>");
document.write(goukei("C",3,7)+"<br>");
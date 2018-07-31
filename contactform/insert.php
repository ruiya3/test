<?php mb_internal_encodin("utf8");

$pdo=new pdo("mysql:dbname=lesson02;host=localhost;","root","");

$pdo->exec("insert into contactform(name,mail,age,comments))
value('".$_POST['name']."','".$_POST['mail'].'",'".$_POST['age'].'",'".$_POST['comments]."');");

?>

<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="utf-8">
	<title>お問合せフォームを作る</title>
	<link rel="stylesheet"type="text/css"href="style2.css">
	</head>
	<body>
	<h1>お問合せフォーム</h1>
		
	<div class ="confirm">
		<p>お問合せ有難うございました。<br>3営業日以内に担当者よりご連絡差し上げます。</p>
		</div>
	</body>
</html>


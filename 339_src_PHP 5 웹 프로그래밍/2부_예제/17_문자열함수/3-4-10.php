<?
$a="영화감상 사진촬영 아이쇼핑";
$b=explode(" ",$a); 

for($i=0 ; $i<3 ; $i++)
{
echo("좋아하는 것 ". ($i+1) ." : $b[$i] <br>");
}
?>

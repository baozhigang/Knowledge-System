<?php
//1. 将数组转为xml
function toXml($array){
    $xml = '<xml>';
    foreach($array as $key=>$val){
        if(is_numeric($val)){
            $xml.='<'.$key.'>'.$val.'</'.$key.'>';
        }else{
            $xml.="<".$key."><![CDATA[".$val."]]></".$key.">";
        }
    }
    $xml.='</xml>';
    return $xml;
}

//2. 解析xml字符串，返回数组
function parseXML($xmlSrc){

    if(empty($xmlSrc)) return false;

    $array = array();
    $xml = simplexml_load_string($xmlSrc);

    if($xml && $xml->children()) {
        foreach ($xml->children() as $node){
            //有子节点
            if($node->children()) {
                $k = $node->getName();
                $nodeXml = $node->asXML();
                $v = substr($nodeXml, strlen($k)+2, strlen($nodeXml)-2*strlen($k)-5);
            } else {
                $k = $node->getName();
                $v = (string)$node;
            }
            $array[$k] = $v;
        }
    }

    return $array;
}

//3. 发送xml字符串，返回数据格式看接口情况
function postxmlData($url, $strxml)
{
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_TIMEOUT, 30);
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_SSL_VERIFYPEER,TRUE);
    curl_setopt($ch, CURLOPT_SSL_VERIFYHOST,2);//严格校验
    curl_setopt($ch, CURLOPT_HEADER, FALSE);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
    curl_setopt($ch, CURLOPT_POST, TRUE);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $strxml);
    $result = curl_exec($ch);
    curl_close($ch);
    return $result;
}

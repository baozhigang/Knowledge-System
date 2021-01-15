<?php

/**
 * 上传文件到阿里云服务器
 */
function uploadOss($data)
{
    $file_path = getArrVal($data, 'file_path');

    if (empty($file_path)) {
        return '';
    }

    $file_info = pathinfo($file_path);
    $extension = $file_info['extension'];;
    $file_name = getArrVal($data, 'file_name', '导出数据') .'_'. date('YmdHis') . rand(1,1000) .'.'. $extension;

    ob_start();
    require_once(ROOT.'vendor/aliosstoken/sts.php');
    $sts = ob_get_contents();
    ob_end_clean();
    $sts = json_decode($sts, 1);
    if (empty($sts)) {
        return '';
    }

    $accessKeyId     = $sts['AccessKeyId'];
    $accessKeySecret = $sts['AccessKeySecret'];
    $securityToken   = $sts['SecurityToken'];
    $endpoint        = getConfig('END_POINT');
    $bucket          = getConfig('BUCKET');

    $ossClient = new \OSS\OssClient($accessKeyId, $accessKeySecret, $endpoint, false, $securityToken);
    $result    = $ossClient->uploadFile($bucket, $file_name, $file_path);
    return $result ? $result['info']['url'] : '';
}

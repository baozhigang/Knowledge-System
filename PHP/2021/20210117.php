<?php

function getAccessToken()
{
    if ($this->access_token) {
        return $this->access_token;
    }

    $data   = ['appId' => self::$call_api_conf['AppID'], 'appSecret'=>self::$call_api_conf['AppSecret']];
    $header = ['cache-control: no-cache', 'Content-Type: application/json'];
    $result = self::curlRequest(self::$call_api_conf['access_token_url'], json_encode($data), $header);
    $result = json_decode($result, true);

    if (200 != $result['errCode'] || !isset($result['data']['accessToken']) || empty($result['data']['accessToken'])) {
        throw new \Exception("EC外呼获取凭证失败");
    }
    $this->access_token = $result['data']['accessToken'];

    return $result['data']['accessToken'];
}
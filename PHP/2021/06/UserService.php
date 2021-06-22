<?php

declare(strict_types=1);
/**
 * This file is part of Hyperf.
 *
 * @link     https://www.hyperf.io
 * @document https://hyperf.wiki
 * @contact  group@hyperf.io
 * @license  https://github.com/hyperf/hyperf/blob/master/LICENSE
 */
namespace App\Service;

class UserService implements UserServiceInterface
{
    /**
     * @var bool
     */
    private $enableCache;

    public function __construct(bool $enableCache)
    {
        $this->enableCache = $enableCache;
    }

    public function getInfoById(int $id)
    {
        return (new Info())->fill($id);
    }

}

package com.github.marsor.fastec.generators;

import com.example.annotations.AppRegisterGenerator;
import com.github.marsor.mars.wechat.templates.AppRegisterTemplate;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

@AppRegisterGenerator(
        packageName = "com.github.marsor.fastec",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}

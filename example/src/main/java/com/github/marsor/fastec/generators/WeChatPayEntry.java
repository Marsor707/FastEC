package com.github.marsor.fastec.generators;

import com.example.annotations.PayEntryGenerator;
import com.github.marsor.mars.wechat.templates.WXPayEntryTemplate;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

@PayEntryGenerator(
        packageName = "com.github.marsor.fastec",
        PayEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}

package com.github.marsor.fastec.generators;

import com.example.annotations.EntryGenerator;
import com.github.marsor.mars.wechat.templates.WXEntryTemplate;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */

@EntryGenerator(
        packageName = "com.github.marsor.fastec",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}

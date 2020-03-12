package org.javaboy.vhr.utils;

import org.javaboy.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author shigm
 * @date 2020/2/23 15:05
 */
public class HrUtils {

    public static Hr getCurrentHr() {
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return hr;
    }
}

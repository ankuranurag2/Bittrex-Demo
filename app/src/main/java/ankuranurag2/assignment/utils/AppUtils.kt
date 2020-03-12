package ankuranurag2.assignment.utils

import ankuranurag2.assignment.BuildConfig

/**
 * created by ankur on 12/3/20
 */
fun isUAT() = BuildConfig.VERSION_NAME.contains("DEV")
package com.go.store;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public final class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("OpenSans-CondLight.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
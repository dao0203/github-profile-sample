package com.example.jetpack_glance_sample.widget

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class GithubContributionsWidgetReceiver(override val glanceAppWidget: GlanceAppWidget = GithubContributionsWidget()) :
    GlanceAppWidgetReceiver()
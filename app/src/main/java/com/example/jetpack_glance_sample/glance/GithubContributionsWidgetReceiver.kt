package com.example.jetpack_glance_sample.glance

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class GithubContributionsWidgetReceiver(override val glanceAppWidget: GlanceAppWidget = GithubContributionsWidget()) :
    GlanceAppWidgetReceiver()
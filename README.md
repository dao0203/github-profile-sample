# jetpack-glance-sample
Jetpack Glance他、koin,github actions, reviewdog, apollographqlなどを用いたAndroidモバイルアプリです。

## 概要
- github actionsを使用し、コード解析とreviewdogを導入
  - https://github.com/dao0203/github-profile-sample/blob/main/.github/workflows/review-suggest.yml
- github graphqlから取得した2ヶ月分のContributionを表示
  - https://github.com/dao0203/github-profile-sample/pull/8
- jetpack-glanceを使用して2ヶ月分のContributionをAppWidgetに表示
  - https://github.com/dao0203/github-profile-sample/blob/main/app/src/main/java/com/example/jetpack_glance_sample/widget/GithubContributionsWidget.kt
  - https://github.com/dao0203/github-profile-sample/pull/25

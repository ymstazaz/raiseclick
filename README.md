# アプリケーション名
raise click

# アプリケーション概要
旅行をラフに検索、ラフに投稿することでまだ見ぬ日本を見つけるためのアプリです。

# URL

# テスト用アカウント

# 利用方法
①ユーザー登録は不要！

②”旅行を検索”をクリックし、目的やエリアを１フォームに１ワードずつ入力し、”検索”することでそのワードが記載されているクチコミが表示される。

③”クチコミ投稿”をクリックし、必須（エリア、シチュエーション、目的、年代、性別）と任意（目的に対する満足度、フリーコメント）を入力し、”投稿”を押すとクチコミを投稿できる。

# アプリケーションを作成した背景
・SNSや旅行サイトを見ると、クチコミや記事が圧倒的にオーバーツーリズムが課題視されているエリアのものが多いが、あまり注目されていないエリアについてもビュー数に関係なく見られやすくなるアプリを作成したかった。

・ビュー数やいいね数を気にしない人はそもそもクチコミといった形で長文を考えるのが好きでない人が多いのではないかと考え、必要最低限のクチコミ投稿機能と複数のワードの掛け合わせ検索を可能とすることで、クチコミを書く人を増やしてまだ見ぬ日本を見つけたい。

# 実装した機能についての画像やGIFおよびその説明
・ユーザー新規登録機能・ログイン機能

└メインページから必要情報を入力すると新規登録、ログインができ、ログインし次第登録のアドレスが表示される。
また、メインページにはこれまでのクチコミ投稿が簡易で見れる。


https://github.com/user-attachments/assets/9ae34192-8cac-47eb-bb97-ad4e5fa5bf8d



・ログアウト機能

└メインページよりログアウトができる


https://github.com/user-attachments/assets/264fd837-b4c5-41ec-af94-a5fa5dc3c9f3



・クチコミ投稿機能

└メインページ、もしくは旅先検索のどちらかのヘッダーからクチコミ投稿ボタンを押すと
クチコミ投稿ページに遷移し、任意の項目以外を入力し、投稿ボタンを押すと投稿でき、メインページにリダイレクトされる。
※シチュエーションと年代は選択式


https://github.com/user-attachments/assets/2982ac86-63c4-4992-9fb0-0c49c65b4dd9



・旅先検索機能

└メインページの旅先検索ボタンからシチュエーション（必須）、年代（必須）、目的（任意）を選択、入力すると
該当のクチコミが一覧で表示される。


https://github.com/user-attachments/assets/1732c983-4128-4dab-81c3-d14dd1e55860




# 実装予定機能
・部分テンプレートを入れて可読性をあげる

・画像投稿機能

・検索後エリア毎にまとめる等データが増えた時のビューを検討

・しっかり書きたい人向けの”旅行記”投稿機能（ユーザーログイン必須）

・観光地スタッフ向けの旅行地登録機能

・ユーザーベースの投稿一覧・編集・削除機能

・目的を複数選択できるようにしてそれに対するオススメ度を入れれるようにする。

・旅行ルート登録機能（スポットを順番付けで複数個設定できるようにする）

➡️12月中目処で実装完了させたい。

・グーグルマップと連動させてあいまい検索での移動時間自動計算機能と、それを検索かける機能

➡️1月中旬目処で実装完了させたい。

# データベース設計
➡️miroにて管理　https://gyazo.com/1738615a21408a661c12dd0122ac5c94


usersテーブル

 id          BIGINT AUTO_INCREMENT PRIMARY KEY,
 
name        VARCHAR(50) NOT NULL,
 
address     VARCHAR(100) NOT NULL UNIQUE,
 
password    VARCHAR(255) NOT NULL,
 
prefecture  VARCHAR(50) NOT NULL,
 
city        VARCHAR(50) NOT NULL,
 
gender      VARCHAR(50) NOT NULL,
 
age         VARCHAR(50) NOT NULL


 spotテーブル
  
id BIGINT AUTO_INCREMENT PRIMARY KEY,
  
spot_name VARCHAR(255) NOT NULL UNIQUE


 reviewテーブル
 
id            BIGINT AUTO_INCREMENT PRIMARY KEY,
 
image_path    VARCHAR(255),
 
situation     VARCHAR(50) NOT NULL,
 
review_age    VARCHAR(50) NOT NULL,
 
review_gender VARCHAR(50) NOT NULL,
 
free_comment  TEXT,
 
spot_id       BIGINT NOT NULL,
 
user_id       BIGINT,
 
created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 
FOREIGN KEY (spot_id) REFERENCES spot(id),
 
FOREIGN KEY (user_id) REFERENCES user(id)


 purposeテーブル
 
id            BIGINT AUTO_INCREMENT PRIMARY KEY,
 
purpose_name  VARCHAR(100) NOT NULL UNIQUE


 review_purposeテーブル
 
id            BIGINT AUTO_INCREMENT PRIMARY KEY,
 
review_id     BIGINT NOT NULL,
 
purpose_id    BIGINT NOT NULL,
 
nth_purpose   INT,
 
satisfaction  INT,
 
FOREIGN KEY (review_id) REFERENCES review(id) ON DELETE CASCADE,
 
FOREIGN KEY (purpose_id) REFERENCES purpose(id) ON DELETE CASCADE



# 画面遷移図
➡️miroにて管理　https://gyazo.com/380c7a7031060c083aa5cc07da9cb165


# 開発環境
IntelliJ
SpringBoot

# ローカルでの動作方法

# 工夫したポイント
・Javaへの理解を深めるために極力、依存関係（dependencies）を極力追加実装しないようにした。

・複数個掛け合わせ検索を可能にした。


# 改善点
・入力フォームを残したまま検索結果がでるように修正。

・クチコミに発地も入れて検索に追加する。

・テストコードの実施。

・掛け合わせ検索の際、完全にマッチしてないものも第2候補として表出する。

・年齢・性別・都道府県はENUMで設計しなおす。

・検索ページを部分テンプレートにして遷移回数を減少させる。

・検索をJavaScriptで動的に追加していけるようにする。

・全体的にビューに独創性を持たせる。

# 制作時間
2週間

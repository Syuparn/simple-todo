# simple-todo

シンプルなtodo管理アプリ（Javaの勉強として作成）

コンソール上でtodoリストを作成、管理できます。

```
commands: create | find | list | delete
list
------------------------------
push github #git
fix bugs #develop
update readme #doc #git
------------------------------
```

各todo項目には、`#hoge`の形でタグを付けることが可能です。タグはtodo項目の検索に利用します（後述）。
作成したtodo項目は`todo.json`にJSON形式で保存されます。

## run

```
# ビルド
gradle build
# 実行
gradle run --console=plain
```

注：対話式CLIなので画面が見やすいように`--console=plain`でプログレスバーを消しています。

## usage
### `create`: todo項目の作成
やるべきことが増えたら、todo項目を追加しましょう。

```
commands: create | find | list | delete
create
Input to-do item:
new note #sample
------------------------------
added: new note #sample
------------------------------
```

### `list`: todo項目を一覧
やるべきことの一覧を確認出来ます。

```
commands: create | find | list | delete
list
------------------------------
push github #git
fix bugs #develop
update readme #doc #git
new note #sample
------------------------------
```

### `find`: タグによるtodo項目の検索
todo項目が多すぎるときは、タグを使って絞り込みましょう。

```
commands: create | find | list | delete
find
Input tag:
git
------------------------------
push github #git
update readme #doc #git
------------------------------
```


### `delete`: todo項目の削除
おめでとうございます！やるべきことが完了しました！todo項目を一覧から削除しましょう。

```
commands: create | find | list | delete
delete
Input to-do item:
update readme #doc #git
------------------------------
deleted
------------------------------
```

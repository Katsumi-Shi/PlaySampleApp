# --- !Ups

INSERT INTO t_user
(
  name,
  school_year,
  height,
  food,
)
VALUES
(
  '高海 千歌',
  2,
  157,
  'みかん！',
),
(
  '桜内 梨子',
  2,
  160,
  'ゆでたまご・サンドイッチ',
),
(
  '松浦 果南',
  3,
  162,
  'さざえ・わかめ',
),

# --- !Downs

delete from t_user;
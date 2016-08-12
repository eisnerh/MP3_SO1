INSERT INTO `proyectoso1`.`usuarios`
(`nombre_usuario`,
`palabra_clave`,
`fecha_compra`,
`fecha_caducidad`)
VALUES
('admin',
'abcd',
current_date(),
date_add(current_date(),interval 30 day));

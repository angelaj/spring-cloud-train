/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50019
Source Host           : localhost:3306
Source Database       : ms

Target Server Type    : MYSQL
Target Server Version : 50019
File Encoding         : 65001

Date: 2019-02-19 12:48:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` bigint(20) NOT NULL auto_increment,
  `dic_code` varchar(20) default NULL COMMENT '字典编码',
  `item_name` varchar(10) default NULL COMMENT '字典项名称',
  `item_value` int(10) default NULL COMMENT '字典项值',
  `item_seq` int(10) default NULL COMMENT '字典项顺序号',
  `item_remark` varchar(255) default NULL COMMENT '字典项备注',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `idx_code_name` USING BTREE (`dic_code`,`item_name`),
  UNIQUE KEY `idx_code_value` USING BTREE (`dic_code`,`item_value`),
  KEY `idx_code` USING BTREE (`dic_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('1', 'role_type', '管理员', '1', '2', '角色类别：管理员', '2019-02-11 17:47:28', '2019-02-12 09:31:53');
INSERT INTO `dictionary` VALUES ('2', 'role_type', '操作员', '2', '3', '角色类别：操作员', '2019-02-11 17:47:57', '2019-02-12 09:31:58');
INSERT INTO `dictionary` VALUES ('3', 'resource_type', '目录', '0', '1', '资源类型：目录', '2019-02-11 18:15:25', '2019-02-11 18:15:27');
INSERT INTO `dictionary` VALUES ('4', 'resource_type', '菜单', '1', '2', '资源类型：菜单', '2019-02-11 18:15:47', '2019-02-11 18:15:49');
INSERT INTO `dictionary` VALUES ('5', 'resource_type', '按钮', '2', '3', '资源类型：按钮', '2019-02-11 18:16:07', '2019-02-11 18:16:09');
INSERT INTO `dictionary` VALUES ('6', 'role_type', '超级管理员', '0', '1', '超级管理员拥有最多的权限', '2019-02-12 09:25:45', '2019-02-12 09:31:37');

-- ----------------------------
-- Table structure for icon
-- ----------------------------
DROP TABLE IF EXISTS `icon`;
CREATE TABLE `icon` (
  `id` bigint(20) NOT NULL auto_increment,
  `icon_name` varchar(50) default NULL COMMENT '图标名称',
  `icon_style` varchar(255) default NULL COMMENT '图标样式',
  `create_time` datetime default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `idx_style` USING BTREE (`icon_style`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of icon
-- ----------------------------
INSERT INTO `icon` VALUES ('1', '500px', 'fa-500px', '2019-02-14 15:59:31');
INSERT INTO `icon` VALUES ('2', 'amazon', 'fa-amazon', '2019-02-14 15:59:58');
INSERT INTO `icon` VALUES ('3', 'balance-scale', 'fa-balance-scale', '2019-02-14 16:00:36');
INSERT INTO `icon` VALUES ('4', 'address-book', 'fa-address-book', '2019-02-18 10:34:31');
INSERT INTO `icon` VALUES ('5', 'address-book-o', 'fa-address-book-o', '2019-02-18 10:34:36');
INSERT INTO `icon` VALUES ('6', 'address-card', 'fa-address-card', '2019-02-18 10:34:38');
INSERT INTO `icon` VALUES ('7', 'address-card-o', 'fa-address-card-o', '2019-02-18 10:34:39');
INSERT INTO `icon` VALUES ('8', 'bandcamp', 'fa-bandcamp', '2019-02-18 10:34:40');
INSERT INTO `icon` VALUES ('9', 'bath', 'fa-bath', '2019-02-18 10:34:42');
INSERT INTO `icon` VALUES ('10', 'id-card', 'fa-id-card', '2019-02-18 10:34:43');
INSERT INTO `icon` VALUES ('11', 'id-card-o', 'fa-id-card-o', '2019-02-18 10:34:44');
INSERT INTO `icon` VALUES ('12', 'eercast', 'fa-eercast', '2019-02-18 10:34:46');
INSERT INTO `icon` VALUES ('13', 'envelope-open', 'fa-envelope-open', '2019-02-18 10:34:47');
INSERT INTO `icon` VALUES ('14', 'envelope-open-o', 'fa-envelope-open-o', '2019-02-18 10:34:48');
INSERT INTO `icon` VALUES ('15', 'etsy', 'fa-etsy', '2019-02-18 10:34:50');
INSERT INTO `icon` VALUES ('16', 'free-code-camp', 'fa-free-code-camp', '2019-02-18 10:34:51');
INSERT INTO `icon` VALUES ('17', 'grav', 'fa-grav', '2019-02-18 10:34:53');
INSERT INTO `icon` VALUES ('18', 'handshake-o', 'fa-handshake-o', '2019-02-18 10:34:54');
INSERT INTO `icon` VALUES ('19', 'id-badge', 'fa-id-badge', '2019-02-18 10:34:55');
INSERT INTO `icon` VALUES ('20', 'imdb', 'fa-imdb', '2019-02-18 10:34:57');
INSERT INTO `icon` VALUES ('21', 'linode', 'fa-linode', '2019-02-18 10:34:58');
INSERT INTO `icon` VALUES ('22', 'meetup', 'fa-meetup', '2019-02-18 10:35:00');
INSERT INTO `icon` VALUES ('23', 'microchip', 'fa-microchip', '2019-02-18 10:35:01');
INSERT INTO `icon` VALUES ('24', 'podcast', 'fa-podcast', '2019-02-18 10:35:02');
INSERT INTO `icon` VALUES ('25', 'quora', 'fa-quora', '2019-02-18 10:35:04');
INSERT INTO `icon` VALUES ('26', 'ravelry', 'fa-ravelry', '2019-02-18 10:35:05');
INSERT INTO `icon` VALUES ('27', 'shower', 'fa-shower', '2019-02-18 10:35:07');
INSERT INTO `icon` VALUES ('28', 'snowflake-o', 'fa-snowflake-o', '2019-02-18 10:35:08');
INSERT INTO `icon` VALUES ('29', 'superpowers', 'fa-superpowers', '2019-02-18 10:35:09');
INSERT INTO `icon` VALUES ('30', 'telegram', 'fa-telegram', '2019-02-18 10:35:11');
INSERT INTO `icon` VALUES ('31', 'thermometer-full', 'fa-thermometer-full', '2019-02-18 10:35:12');
INSERT INTO `icon` VALUES ('32', 'thermometer-empty', 'fa-thermometer-empty', '2019-02-18 10:35:13');
INSERT INTO `icon` VALUES ('33', 'thermometer-quarter', 'fa-thermometer-quarter', '2019-02-18 10:35:15');
INSERT INTO `icon` VALUES ('34', 'thermometer-half', 'fa-thermometer-half', '2019-02-18 10:35:16');
INSERT INTO `icon` VALUES ('35', 'thermometer-three-quarters', 'fa-thermometer-three-quarters', '2019-02-18 10:35:17');
INSERT INTO `icon` VALUES ('36', 'window-close', 'fa-window-close', '2019-02-18 10:35:19');
INSERT INTO `icon` VALUES ('37', 'window-close-o', 'fa-window-close-o', '2019-02-18 10:35:20');
INSERT INTO `icon` VALUES ('38', 'user-circle', 'fa-user-circle', '2019-02-18 10:35:21');
INSERT INTO `icon` VALUES ('39', 'user-circle-o', 'fa-user-circle-o', '2019-02-18 10:35:23');
INSERT INTO `icon` VALUES ('40', 'user-o', 'fa-user-o', '2019-02-18 10:35:24');
INSERT INTO `icon` VALUES ('41', 'window-maximize', 'fa-window-maximize', '2019-02-18 10:35:25');
INSERT INTO `icon` VALUES ('42', 'window-minimize', 'fa-window-minimize', '2019-02-18 10:35:26');
INSERT INTO `icon` VALUES ('43', 'window-restore', 'fa-window-restore', '2019-02-18 10:35:28');
INSERT INTO `icon` VALUES ('44', 'wpexplorer', 'fa-wpexplorer', '2019-02-18 10:35:29');
INSERT INTO `icon` VALUES ('45', 'adjust', 'fa-adjust', '2019-02-18 10:35:30');
INSERT INTO `icon` VALUES ('46', 'american-sign-language-interpreting', 'fa-american-sign-language-interpreting', '2019-02-18 10:35:32');
INSERT INTO `icon` VALUES ('47', 'anchor', 'fa-anchor', '2019-02-18 10:35:33');
INSERT INTO `icon` VALUES ('48', 'archive', 'fa-archive', '2019-02-18 10:35:34');
INSERT INTO `icon` VALUES ('49', 'area-chart', 'fa-area-chart', '2019-02-18 10:35:36');
INSERT INTO `icon` VALUES ('50', 'arrows', 'fa-arrows', '2019-02-18 10:35:37');
INSERT INTO `icon` VALUES ('51', 'arrows-h', 'fa-arrows-h', '2019-02-18 10:35:39');
INSERT INTO `icon` VALUES ('52', 'arrows-v', 'fa-arrows-v', '2019-02-18 10:35:40');
INSERT INTO `icon` VALUES ('53', 'assistive-listening-systems', 'fa-assistive-listening-systems', '2019-02-18 10:35:41');
INSERT INTO `icon` VALUES ('54', 'asterisk', 'fa-asterisk', '2019-02-18 10:35:43');
INSERT INTO `icon` VALUES ('55', 'at', 'fa-at', '2019-02-18 10:35:44');
INSERT INTO `icon` VALUES ('56', 'audio-description', 'fa-audio-description', '2019-02-18 10:35:46');
INSERT INTO `icon` VALUES ('57', 'car', 'fa-car', '2019-02-18 10:35:47');
INSERT INTO `icon` VALUES ('58', 'ban', 'fa-ban', '2019-02-18 10:35:50');
INSERT INTO `icon` VALUES ('59', 'university', 'fa-university', '2019-02-18 10:35:51');
INSERT INTO `icon` VALUES ('60', 'bar-chart', 'fa-bar-chart', '2019-02-18 10:35:53');
INSERT INTO `icon` VALUES ('61', 'barcode', 'fa-barcode', '2019-02-18 10:35:54');
INSERT INTO `icon` VALUES ('62', 'bars', 'fa-bars', '2019-02-18 10:35:55');
INSERT INTO `icon` VALUES ('63', 'battery-full', 'fa-battery-full', '2019-02-18 10:35:57');
INSERT INTO `icon` VALUES ('64', 'battery-empty', 'fa-battery-empty', '2019-02-18 10:35:58');
INSERT INTO `icon` VALUES ('65', 'battery-quarter', 'fa-battery-quarter', '2019-02-18 10:36:00');
INSERT INTO `icon` VALUES ('66', 'battery-half', 'fa-battery-half', '2019-02-18 10:36:01');
INSERT INTO `icon` VALUES ('67', 'battery-three-quarters', 'fa-battery-three-quarters', '2019-02-18 10:36:03');
INSERT INTO `icon` VALUES ('68', 'bed', 'fa-bed', '2019-02-18 10:36:04');
INSERT INTO `icon` VALUES ('69', 'beer', 'fa-beer', '2019-02-18 10:36:05');
INSERT INTO `icon` VALUES ('70', 'bell', 'fa-bell', '2019-02-18 10:36:07');
INSERT INTO `icon` VALUES ('71', 'bell-o', 'fa-bell-o', '2019-02-18 10:36:08');
INSERT INTO `icon` VALUES ('72', 'bell-slash', 'fa-bell-slash', '2019-02-18 10:36:09');
INSERT INTO `icon` VALUES ('73', 'bell-slash-o', 'fa-bell-slash-o', '2019-02-18 10:36:11');
INSERT INTO `icon` VALUES ('74', 'bicycle', 'fa-bicycle', '2019-02-18 10:36:12');
INSERT INTO `icon` VALUES ('75', 'binoculars', 'fa-binoculars', '2019-02-18 10:36:13');
INSERT INTO `icon` VALUES ('76', 'birthday-cake', 'fa-birthday-cake', '2019-02-18 10:36:15');
INSERT INTO `icon` VALUES ('77', 'blind', 'fa-blind', '2019-02-18 10:36:16');
INSERT INTO `icon` VALUES ('78', 'bluetooth', 'fa-bluetooth', '2019-02-18 10:36:17');
INSERT INTO `icon` VALUES ('79', 'bluetooth-b', 'fa-bluetooth-b', '2019-02-18 10:36:19');
INSERT INTO `icon` VALUES ('80', 'bolt', 'fa-bolt', '2019-02-18 10:36:20');
INSERT INTO `icon` VALUES ('81', 'bomb', 'fa-bomb', '2019-02-18 10:36:21');
INSERT INTO `icon` VALUES ('82', 'book', 'fa-book', '2019-02-18 10:36:23');
INSERT INTO `icon` VALUES ('83', 'bookmark', 'fa-bookmark', '2019-02-18 10:36:24');
INSERT INTO `icon` VALUES ('84', 'bookmark-o', 'fa-bookmark-o', '2019-02-18 10:36:25');
INSERT INTO `icon` VALUES ('85', 'braille', 'fa-braille', '2019-02-18 10:36:27');
INSERT INTO `icon` VALUES ('86', 'briefcase', 'fa-briefcase', '2019-02-18 10:36:28');
INSERT INTO `icon` VALUES ('87', 'bug', 'fa-bug', '2019-02-18 10:36:29');
INSERT INTO `icon` VALUES ('88', 'building', 'fa-building', '2019-02-18 10:36:31');
INSERT INTO `icon` VALUES ('89', 'building-o', 'fa-building-o', '2019-02-18 10:36:32');
INSERT INTO `icon` VALUES ('90', 'bullhorn', 'fa-bullhorn', '2019-02-18 10:36:34');
INSERT INTO `icon` VALUES ('91', 'bullseye', 'fa-bullseye', '2019-02-18 10:36:35');
INSERT INTO `icon` VALUES ('92', 'bus', 'fa-bus', '2019-02-18 10:36:37');
INSERT INTO `icon` VALUES ('93', 'taxi', 'fa-taxi', '2019-02-18 10:36:38');
INSERT INTO `icon` VALUES ('94', 'calculator', 'fa-calculator', '2019-02-18 10:36:39');
INSERT INTO `icon` VALUES ('95', 'calendar', 'fa-calendar', '2019-02-18 10:36:41');
INSERT INTO `icon` VALUES ('96', 'calendar-check-o', 'fa-calendar-check-o', '2019-02-18 10:36:42');
INSERT INTO `icon` VALUES ('97', 'calendar-minus-o', 'fa-calendar-minus-o', '2019-02-18 10:36:44');
INSERT INTO `icon` VALUES ('98', 'calendar-o', 'fa-calendar-o', '2019-02-18 10:36:45');
INSERT INTO `icon` VALUES ('99', 'calendar-plus-o', 'fa-calendar-plus-o', '2019-02-18 10:36:46');
INSERT INTO `icon` VALUES ('100', 'calendar-times-o', 'fa-calendar-times-o', '2019-02-18 10:36:48');
INSERT INTO `icon` VALUES ('101', 'camera', 'fa-camera', '2019-02-18 10:36:49');
INSERT INTO `icon` VALUES ('102', 'camera-retro', 'fa-camera-retro', '2019-02-18 10:36:51');
INSERT INTO `icon` VALUES ('103', 'caret-square-o-down', 'fa-caret-square-o-down', '2019-02-18 10:36:52');
INSERT INTO `icon` VALUES ('104', 'caret-square-o-left', 'fa-caret-square-o-left', '2019-02-18 10:36:53');
INSERT INTO `icon` VALUES ('105', 'caret-square-o-right', 'fa-caret-square-o-right', '2019-02-18 10:36:55');
INSERT INTO `icon` VALUES ('106', 'caret-square-o-up', 'fa-caret-square-o-up', '2019-02-18 10:36:56');
INSERT INTO `icon` VALUES ('107', 'cart-arrow-down', 'fa-cart-arrow-down', '2019-02-18 10:36:58');
INSERT INTO `icon` VALUES ('108', 'cart-plus', 'fa-cart-plus', '2019-02-18 10:36:59');
INSERT INTO `icon` VALUES ('109', 'cc', 'fa-cc', '2019-02-18 10:37:00');
INSERT INTO `icon` VALUES ('110', 'certificate', 'fa-certificate', '2019-02-18 10:37:02');
INSERT INTO `icon` VALUES ('111', 'check', 'fa-check', '2019-02-18 10:37:03');
INSERT INTO `icon` VALUES ('112', 'check-circle', 'fa-check-circle', '2019-02-18 10:37:04');
INSERT INTO `icon` VALUES ('113', 'check-circle-o', 'fa-check-circle-o', '2019-02-18 10:37:06');
INSERT INTO `icon` VALUES ('114', 'check-square', 'fa-check-square', '2019-02-18 10:37:07');
INSERT INTO `icon` VALUES ('115', 'check-square-o', 'fa-check-square-o', '2019-02-18 10:37:09');
INSERT INTO `icon` VALUES ('116', 'child', 'fa-child', '2019-02-18 10:37:10');
INSERT INTO `icon` VALUES ('117', 'circle', 'fa-circle', '2019-02-18 10:37:11');
INSERT INTO `icon` VALUES ('118', 'circle-o', 'fa-circle-o', '2019-02-18 10:37:13');
INSERT INTO `icon` VALUES ('119', 'circle-o-notch', 'fa-circle-o-notch', '2019-02-18 10:37:14');
INSERT INTO `icon` VALUES ('120', 'circle-thin', 'fa-circle-thin', '2019-02-18 10:37:15');
INSERT INTO `icon` VALUES ('121', 'clock-o', 'fa-clock-o', '2019-02-18 10:37:17');
INSERT INTO `icon` VALUES ('122', 'clone', 'fa-clone', '2019-02-18 10:37:18');
INSERT INTO `icon` VALUES ('123', 'times', 'fa-times', '2019-02-18 10:37:20');
INSERT INTO `icon` VALUES ('124', 'cloud', 'fa-cloud', '2019-02-18 10:37:21');
INSERT INTO `icon` VALUES ('125', 'cloud-download', 'fa-cloud-download', '2019-02-18 10:37:22');
INSERT INTO `icon` VALUES ('126', 'cloud-upload', 'fa-cloud-upload', '2019-02-18 10:37:24');
INSERT INTO `icon` VALUES ('127', 'code', 'fa-code', '2019-02-18 10:37:25');
INSERT INTO `icon` VALUES ('128', 'code-fork', 'fa-code-fork', '2019-02-18 10:37:26');
INSERT INTO `icon` VALUES ('129', 'coffee', 'fa-coffee', '2019-02-18 10:37:28');
INSERT INTO `icon` VALUES ('130', 'cog', 'fa-cog', '2019-02-18 10:37:29');
INSERT INTO `icon` VALUES ('131', 'cogs', 'fa-cogs', '2019-02-18 10:37:31');
INSERT INTO `icon` VALUES ('132', 'comment', 'fa-comment', '2019-02-18 10:37:32');
INSERT INTO `icon` VALUES ('133', 'comment-o', 'fa-comment-o', '2019-02-18 10:37:33');
INSERT INTO `icon` VALUES ('134', 'commenting', 'fa-commenting', '2019-02-18 10:37:35');
INSERT INTO `icon` VALUES ('135', 'commenting-o', 'fa-commenting-o', '2019-02-18 10:37:36');
INSERT INTO `icon` VALUES ('136', 'comments', 'fa-comments', '2019-02-18 10:37:37');
INSERT INTO `icon` VALUES ('137', 'comments-o', 'fa-comments-o', '2019-02-18 10:37:39');
INSERT INTO `icon` VALUES ('138', 'compass', 'fa-compass', '2019-02-18 10:37:40');
INSERT INTO `icon` VALUES ('139', 'copyright', 'fa-copyright', '2019-02-18 10:37:41');
INSERT INTO `icon` VALUES ('140', 'creative-commons', 'fa-creative-commons', '2019-02-18 10:37:43');
INSERT INTO `icon` VALUES ('141', 'credit-card', 'fa-credit-card', '2019-02-18 10:37:44');
INSERT INTO `icon` VALUES ('142', 'credit-card-alt', 'fa-credit-card-alt', '2019-02-18 10:37:45');
INSERT INTO `icon` VALUES ('143', 'crop', 'fa-crop', '2019-02-18 10:37:47');
INSERT INTO `icon` VALUES ('144', 'crosshairs', 'fa-crosshairs', '2019-02-18 10:37:48');
INSERT INTO `icon` VALUES ('145', 'cube', 'fa-cube', '2019-02-18 10:37:50');
INSERT INTO `icon` VALUES ('146', 'cubes', 'fa-cubes', '2019-02-18 10:37:51');
INSERT INTO `icon` VALUES ('147', 'cutlery', 'fa-cutlery', '2019-02-18 10:37:53');
INSERT INTO `icon` VALUES ('148', 'tachometer', 'fa-tachometer', '2019-02-18 10:37:54');
INSERT INTO `icon` VALUES ('149', 'database', 'fa-database', '2019-02-18 10:37:55');
INSERT INTO `icon` VALUES ('150', 'deaf', 'fa-deaf', '2019-02-18 10:37:57');
INSERT INTO `icon` VALUES ('151', 'desktop', 'fa-desktop', '2019-02-18 10:37:58');
INSERT INTO `icon` VALUES ('152', 'diamond', 'fa-diamond', '2019-02-18 10:37:59');
INSERT INTO `icon` VALUES ('153', 'dot-circle-o', 'fa-dot-circle-o', '2019-02-18 10:38:01');
INSERT INTO `icon` VALUES ('154', 'download', 'fa-download', '2019-02-18 10:38:02');
INSERT INTO `icon` VALUES ('155', 'pencil-square-o', 'fa-pencil-square-o', '2019-02-18 10:38:03');
INSERT INTO `icon` VALUES ('156', 'ellipsis-h', 'fa-ellipsis-h', '2019-02-18 10:38:05');
INSERT INTO `icon` VALUES ('157', 'ellipsis-v', 'fa-ellipsis-v', '2019-02-18 10:38:06');
INSERT INTO `icon` VALUES ('158', 'envelope', 'fa-envelope', '2019-02-18 10:38:08');
INSERT INTO `icon` VALUES ('159', 'envelope-o', 'fa-envelope-o', '2019-02-18 10:38:09');
INSERT INTO `icon` VALUES ('160', 'envelope-square', 'fa-envelope-square', '2019-02-18 10:38:10');
INSERT INTO `icon` VALUES ('161', 'eraser', 'fa-eraser', '2019-02-18 10:38:12');
INSERT INTO `icon` VALUES ('162', 'exchange', 'fa-exchange', '2019-02-18 10:38:13');
INSERT INTO `icon` VALUES ('163', 'exclamation', 'fa-exclamation', '2019-02-18 10:38:14');
INSERT INTO `icon` VALUES ('164', 'exclamation-circle', 'fa-exclamation-circle', '2019-02-18 10:38:16');
INSERT INTO `icon` VALUES ('165', 'exclamation-triangle', 'fa-exclamation-triangle', '2019-02-18 10:38:17');
INSERT INTO `icon` VALUES ('166', 'external-link', 'fa-external-link', '2019-02-18 10:38:18');
INSERT INTO `icon` VALUES ('167', 'external-link-square', 'fa-external-link-square', '2019-02-18 10:38:20');
INSERT INTO `icon` VALUES ('168', 'eye', 'fa-eye', '2019-02-18 10:38:21');
INSERT INTO `icon` VALUES ('169', 'eye-slash', 'fa-eye-slash', '2019-02-18 10:38:22');
INSERT INTO `icon` VALUES ('170', 'eyedropper', 'fa-eyedropper', '2019-02-18 10:38:24');
INSERT INTO `icon` VALUES ('171', 'fax', 'fa-fax', '2019-02-18 10:38:25');
INSERT INTO `icon` VALUES ('172', 'rss', 'fa-rss', '2019-02-18 10:38:26');
INSERT INTO `icon` VALUES ('173', 'female', 'fa-female', '2019-02-18 10:38:28');
INSERT INTO `icon` VALUES ('174', 'fighter-jet', 'fa-fighter-jet', '2019-02-18 10:38:29');
INSERT INTO `icon` VALUES ('175', 'file-archive-o', 'fa-file-archive-o', '2019-02-18 10:38:30');
INSERT INTO `icon` VALUES ('176', 'file-audio-o', 'fa-file-audio-o', '2019-02-18 10:38:32');
INSERT INTO `icon` VALUES ('177', 'file-code-o', 'fa-file-code-o', '2019-02-18 10:38:33');
INSERT INTO `icon` VALUES ('178', 'file-excel-o', 'fa-file-excel-o', '2019-02-18 10:38:34');
INSERT INTO `icon` VALUES ('179', 'file-image-o', 'fa-file-image-o', '2019-02-18 10:38:35');
INSERT INTO `icon` VALUES ('180', 'file-video-o', 'fa-file-video-o', '2019-02-18 10:38:37');
INSERT INTO `icon` VALUES ('181', 'file-pdf-o', 'fa-file-pdf-o', '2019-02-18 10:38:38');
INSERT INTO `icon` VALUES ('182', 'file-powerpoint-o', 'fa-file-powerpoint-o', '2019-02-18 10:38:39');
INSERT INTO `icon` VALUES ('183', 'file-word-o', 'fa-file-word-o', '2019-02-18 10:38:41');
INSERT INTO `icon` VALUES ('184', 'film', 'fa-film', '2019-02-18 10:38:42');
INSERT INTO `icon` VALUES ('185', 'filter', 'fa-filter', '2019-02-18 10:38:43');
INSERT INTO `icon` VALUES ('186', 'fire', 'fa-fire', '2019-02-18 10:38:45');
INSERT INTO `icon` VALUES ('187', 'fire-extinguisher', 'fa-fire-extinguisher', '2019-02-18 10:38:46');
INSERT INTO `icon` VALUES ('188', 'flag', 'fa-flag', '2019-02-18 10:38:47');
INSERT INTO `icon` VALUES ('189', 'flag-checkered', 'fa-flag-checkered', '2019-02-18 10:38:49');
INSERT INTO `icon` VALUES ('190', 'flag-o', 'fa-flag-o', '2019-02-18 10:38:50');
INSERT INTO `icon` VALUES ('191', 'flask', 'fa-flask', '2019-02-18 10:38:51');
INSERT INTO `icon` VALUES ('192', 'folder', 'fa-folder', '2019-02-18 10:38:53');
INSERT INTO `icon` VALUES ('193', 'folder-o', 'fa-folder-o', '2019-02-18 10:38:54');
INSERT INTO `icon` VALUES ('194', 'folder-open', 'fa-folder-open', '2019-02-18 10:38:55');
INSERT INTO `icon` VALUES ('195', 'folder-open-o', 'fa-folder-open-o', '2019-02-18 10:38:57');
INSERT INTO `icon` VALUES ('196', 'frown-o', 'fa-frown-o', '2019-02-18 10:38:58');
INSERT INTO `icon` VALUES ('197', 'futbol-o', 'fa-futbol-o', '2019-02-18 10:38:59');
INSERT INTO `icon` VALUES ('198', 'gamepad', 'fa-gamepad', '2019-02-18 10:39:01');
INSERT INTO `icon` VALUES ('199', 'gavel', 'fa-gavel', '2019-02-18 10:39:02');
INSERT INTO `icon` VALUES ('200', 'gift', 'fa-gift', '2019-02-18 10:39:03');
INSERT INTO `icon` VALUES ('201', 'glass', 'fa-glass', '2019-02-18 10:39:05');
INSERT INTO `icon` VALUES ('202', 'globe', 'fa-globe', '2019-02-18 10:39:06');
INSERT INTO `icon` VALUES ('203', 'graduation-cap', 'fa-graduation-cap', '2019-02-18 10:39:07');
INSERT INTO `icon` VALUES ('204', 'users', 'fa-users', '2019-02-18 10:39:08');
INSERT INTO `icon` VALUES ('205', 'hand-rock-o', 'fa-hand-rock-o', '2019-02-18 10:39:10');
INSERT INTO `icon` VALUES ('206', 'hand-lizard-o', 'fa-hand-lizard-o', '2019-02-18 10:39:11');
INSERT INTO `icon` VALUES ('207', 'hand-paper-o', 'fa-hand-paper-o', '2019-02-18 10:39:12');
INSERT INTO `icon` VALUES ('208', 'hand-peace-o', 'fa-hand-peace-o', '2019-02-18 10:39:14');
INSERT INTO `icon` VALUES ('209', 'hand-pointer-o', 'fa-hand-pointer-o', '2019-02-18 10:39:15');
INSERT INTO `icon` VALUES ('210', 'hand-scissors-o', 'fa-hand-scissors-o', '2019-02-18 10:39:16');
INSERT INTO `icon` VALUES ('211', 'hand-spock-o', 'fa-hand-spock-o', '2019-02-18 10:39:18');
INSERT INTO `icon` VALUES ('212', 'hashtag', 'fa-hashtag', '2019-02-18 10:39:19');
INSERT INTO `icon` VALUES ('213', 'hdd-o', 'fa-hdd-o', '2019-02-18 10:39:20');
INSERT INTO `icon` VALUES ('214', 'headphones', 'fa-headphones', '2019-02-18 10:39:21');
INSERT INTO `icon` VALUES ('215', 'heart', 'fa-heart', '2019-02-18 10:39:23');
INSERT INTO `icon` VALUES ('216', 'heart-o', 'fa-heart-o', '2019-02-18 10:39:24');
INSERT INTO `icon` VALUES ('217', 'heartbeat', 'fa-heartbeat', '2019-02-18 10:39:25');
INSERT INTO `icon` VALUES ('218', 'history', 'fa-history', '2019-02-18 10:39:27');
INSERT INTO `icon` VALUES ('219', 'home', 'fa-home', '2019-02-18 10:39:28');
INSERT INTO `icon` VALUES ('220', 'hourglass', 'fa-hourglass', '2019-02-18 10:39:29');
INSERT INTO `icon` VALUES ('221', 'hourglass-start', 'fa-hourglass-start', '2019-02-18 10:39:31');
INSERT INTO `icon` VALUES ('222', 'hourglass-half', 'fa-hourglass-half', '2019-02-18 10:39:32');
INSERT INTO `icon` VALUES ('223', 'hourglass-end', 'fa-hourglass-end', '2019-02-18 10:39:33');
INSERT INTO `icon` VALUES ('224', 'hourglass-o', 'fa-hourglass-o', '2019-02-18 10:39:35');
INSERT INTO `icon` VALUES ('225', 'i-cursor', 'fa-i-cursor', '2019-02-18 10:39:36');
INSERT INTO `icon` VALUES ('226', 'picture-o', 'fa-picture-o', '2019-02-18 10:39:37');
INSERT INTO `icon` VALUES ('227', 'inbox', 'fa-inbox', '2019-02-18 10:39:39');
INSERT INTO `icon` VALUES ('228', 'industry', 'fa-industry', '2019-02-18 10:39:40');
INSERT INTO `icon` VALUES ('229', 'info', 'fa-info', '2019-02-18 10:39:41');
INSERT INTO `icon` VALUES ('230', 'info-circle', 'fa-info-circle', '2019-02-18 10:39:43');
INSERT INTO `icon` VALUES ('231', 'key', 'fa-key', '2019-02-18 10:39:44');
INSERT INTO `icon` VALUES ('232', 'keyboard-o', 'fa-keyboard-o', '2019-02-18 10:39:45');
INSERT INTO `icon` VALUES ('233', 'language', 'fa-language', '2019-02-18 10:39:46');
INSERT INTO `icon` VALUES ('234', 'laptop', 'fa-laptop', '2019-02-18 10:39:48');
INSERT INTO `icon` VALUES ('235', 'leaf', 'fa-leaf', '2019-02-18 10:39:49');
INSERT INTO `icon` VALUES ('236', 'lemon-o', 'fa-lemon-o', '2019-02-18 10:39:51');
INSERT INTO `icon` VALUES ('237', 'level-down', 'fa-level-down', '2019-02-18 10:39:52');
INSERT INTO `icon` VALUES ('238', 'level-up', 'fa-level-up', '2019-02-18 10:39:53');
INSERT INTO `icon` VALUES ('239', 'life-ring', 'fa-life-ring', '2019-02-18 10:39:55');
INSERT INTO `icon` VALUES ('240', 'lightbulb-o', 'fa-lightbulb-o', '2019-02-18 10:39:56');
INSERT INTO `icon` VALUES ('241', 'line-chart', 'fa-line-chart', '2019-02-18 10:39:57');
INSERT INTO `icon` VALUES ('242', 'location-arrow', 'fa-location-arrow', '2019-02-18 10:39:59');
INSERT INTO `icon` VALUES ('243', 'lock', 'fa-lock', '2019-02-18 10:40:00');
INSERT INTO `icon` VALUES ('244', 'low-vision', 'fa-low-vision', '2019-02-18 10:40:01');
INSERT INTO `icon` VALUES ('245', 'magic', 'fa-magic', '2019-02-18 10:40:03');
INSERT INTO `icon` VALUES ('246', 'magnet', 'fa-magnet', '2019-02-18 10:40:04');
INSERT INTO `icon` VALUES ('247', 'share', 'fa-share', '2019-02-18 10:40:06');
INSERT INTO `icon` VALUES ('248', 'reply', 'fa-reply', '2019-02-18 10:40:07');
INSERT INTO `icon` VALUES ('249', 'reply-all', 'fa-reply-all', '2019-02-18 10:40:08');
INSERT INTO `icon` VALUES ('250', 'male', 'fa-male', '2019-02-18 10:40:10');
INSERT INTO `icon` VALUES ('251', 'map', 'fa-map', '2019-02-18 10:40:11');
INSERT INTO `icon` VALUES ('252', 'map-marker', 'fa-map-marker', '2019-02-18 10:40:12');
INSERT INTO `icon` VALUES ('253', 'map-o', 'fa-map-o', '2019-02-18 10:40:14');
INSERT INTO `icon` VALUES ('254', 'map-pin', 'fa-map-pin', '2019-02-18 10:40:15');
INSERT INTO `icon` VALUES ('255', 'map-signs', 'fa-map-signs', '2019-02-18 10:40:16');
INSERT INTO `icon` VALUES ('256', 'meh-o', 'fa-meh-o', '2019-02-18 10:40:18');
INSERT INTO `icon` VALUES ('257', 'microphone', 'fa-microphone', '2019-02-18 10:40:19');
INSERT INTO `icon` VALUES ('258', 'microphone-slash', 'fa-microphone-slash', '2019-02-18 10:40:21');
INSERT INTO `icon` VALUES ('259', 'minus', 'fa-minus', '2019-02-18 10:40:22');
INSERT INTO `icon` VALUES ('260', 'minus-circle', 'fa-minus-circle', '2019-02-18 10:40:23');
INSERT INTO `icon` VALUES ('261', 'minus-square', 'fa-minus-square', '2019-02-18 10:40:25');
INSERT INTO `icon` VALUES ('262', 'minus-square-o', 'fa-minus-square-o', '2019-02-18 10:40:26');
INSERT INTO `icon` VALUES ('263', 'mobile', 'fa-mobile', '2019-02-18 10:40:27');
INSERT INTO `icon` VALUES ('264', 'money', 'fa-money', '2019-02-18 10:40:29');
INSERT INTO `icon` VALUES ('265', 'moon-o', 'fa-moon-o', '2019-02-18 10:40:30');
INSERT INTO `icon` VALUES ('266', 'motorcycle', 'fa-motorcycle', '2019-02-18 10:40:31');
INSERT INTO `icon` VALUES ('267', 'mouse-pointer', 'fa-mouse-pointer', '2019-02-18 10:40:33');
INSERT INTO `icon` VALUES ('268', 'music', 'fa-music', '2019-02-18 10:40:34');
INSERT INTO `icon` VALUES ('269', 'newspaper-o', 'fa-newspaper-o', '2019-02-18 10:40:35');
INSERT INTO `icon` VALUES ('270', 'object-group', 'fa-object-group', '2019-02-18 10:40:37');
INSERT INTO `icon` VALUES ('271', 'object-ungroup', 'fa-object-ungroup', '2019-02-18 10:40:38');
INSERT INTO `icon` VALUES ('272', 'paint-brush', 'fa-paint-brush', '2019-02-18 10:40:39');
INSERT INTO `icon` VALUES ('273', 'paper-plane', 'fa-paper-plane', '2019-02-18 10:40:41');
INSERT INTO `icon` VALUES ('274', 'paper-plane-o', 'fa-paper-plane-o', '2019-02-18 10:40:42');
INSERT INTO `icon` VALUES ('275', 'paw', 'fa-paw', '2019-02-18 10:40:43');
INSERT INTO `icon` VALUES ('276', 'pencil', 'fa-pencil', '2019-02-18 10:40:45');
INSERT INTO `icon` VALUES ('277', 'pencil-square', 'fa-pencil-square', '2019-02-18 10:40:46');
INSERT INTO `icon` VALUES ('278', 'percent', 'fa-percent', '2019-02-18 10:40:47');
INSERT INTO `icon` VALUES ('279', 'phone', 'fa-phone', '2019-02-18 10:40:49');
INSERT INTO `icon` VALUES ('280', 'phone-square', 'fa-phone-square', '2019-02-18 10:40:50');
INSERT INTO `icon` VALUES ('281', 'pie-chart', 'fa-pie-chart', '2019-02-18 10:40:51');
INSERT INTO `icon` VALUES ('282', 'plane', 'fa-plane', '2019-02-18 10:40:53');
INSERT INTO `icon` VALUES ('283', 'plug', 'fa-plug', '2019-02-18 10:40:54');
INSERT INTO `icon` VALUES ('284', 'plus', 'fa-plus', '2019-02-18 10:40:56');
INSERT INTO `icon` VALUES ('285', 'plus-circle', 'fa-plus-circle', '2019-02-18 10:40:57');
INSERT INTO `icon` VALUES ('286', 'plus-square', 'fa-plus-square', '2019-02-18 10:40:58');
INSERT INTO `icon` VALUES ('287', 'plus-square-o', 'fa-plus-square-o', '2019-02-18 10:41:00');
INSERT INTO `icon` VALUES ('288', 'power-off', 'fa-power-off', '2019-02-18 10:41:01');
INSERT INTO `icon` VALUES ('289', 'print', 'fa-print', '2019-02-18 10:41:02');
INSERT INTO `icon` VALUES ('290', 'puzzle-piece', 'fa-puzzle-piece', '2019-02-18 10:41:04');
INSERT INTO `icon` VALUES ('291', 'qrcode', 'fa-qrcode', '2019-02-18 10:41:05');
INSERT INTO `icon` VALUES ('292', 'question', 'fa-question', '2019-02-18 10:41:06');
INSERT INTO `icon` VALUES ('293', 'question-circle', 'fa-question-circle', '2019-02-18 10:41:08');
INSERT INTO `icon` VALUES ('294', 'question-circle-o', 'fa-question-circle-o', '2019-02-18 10:41:09');
INSERT INTO `icon` VALUES ('295', 'quote-left', 'fa-quote-left', '2019-02-18 10:41:11');
INSERT INTO `icon` VALUES ('296', 'quote-right', 'fa-quote-right', '2019-02-18 10:41:12');
INSERT INTO `icon` VALUES ('297', 'random', 'fa-random', '2019-02-18 10:41:13');
INSERT INTO `icon` VALUES ('298', 'recycle', 'fa-recycle', '2019-02-18 10:41:15');
INSERT INTO `icon` VALUES ('299', 'refresh', 'fa-refresh', '2019-02-18 10:41:16');
INSERT INTO `icon` VALUES ('300', 'registered', 'fa-registered', '2019-02-18 10:41:17');
INSERT INTO `icon` VALUES ('301', 'retweet', 'fa-retweet', '2019-02-18 10:41:19');
INSERT INTO `icon` VALUES ('302', 'road', 'fa-road', '2019-02-18 10:41:20');
INSERT INTO `icon` VALUES ('303', 'rocket', 'fa-rocket', '2019-02-18 10:41:21');
INSERT INTO `icon` VALUES ('304', 'rss-square', 'fa-rss-square', '2019-02-18 10:41:23');
INSERT INTO `icon` VALUES ('305', 'search', 'fa-search', '2019-02-18 10:41:24');
INSERT INTO `icon` VALUES ('306', 'search-minus', 'fa-search-minus', '2019-02-18 10:41:25');
INSERT INTO `icon` VALUES ('307', 'search-plus', 'fa-search-plus', '2019-02-18 10:41:27');
INSERT INTO `icon` VALUES ('308', 'server', 'fa-server', '2019-02-18 10:41:28');
INSERT INTO `icon` VALUES ('309', 'share-alt', 'fa-share-alt', '2019-02-18 10:41:30');
INSERT INTO `icon` VALUES ('310', 'share-alt-square', 'fa-share-alt-square', '2019-02-18 10:41:31');
INSERT INTO `icon` VALUES ('311', 'share-square', 'fa-share-square', '2019-02-18 10:41:32');
INSERT INTO `icon` VALUES ('312', 'share-square-o', 'fa-share-square-o', '2019-02-18 10:41:34');
INSERT INTO `icon` VALUES ('313', 'shield', 'fa-shield', '2019-02-18 10:41:35');
INSERT INTO `icon` VALUES ('314', 'ship', 'fa-ship', '2019-02-18 10:41:36');
INSERT INTO `icon` VALUES ('315', 'shopping-bag', 'fa-shopping-bag', '2019-02-18 10:41:38');
INSERT INTO `icon` VALUES ('316', 'shopping-basket', 'fa-shopping-basket', '2019-02-18 10:41:39');
INSERT INTO `icon` VALUES ('317', 'shopping-cart', 'fa-shopping-cart', '2019-02-18 10:41:40');
INSERT INTO `icon` VALUES ('318', 'sign-in', 'fa-sign-in', '2019-02-18 10:41:42');
INSERT INTO `icon` VALUES ('319', 'sign-language', 'fa-sign-language', '2019-02-18 10:41:43');
INSERT INTO `icon` VALUES ('320', 'sign-out', 'fa-sign-out', '2019-02-18 10:41:44');
INSERT INTO `icon` VALUES ('321', 'signal', 'fa-signal', '2019-02-18 10:41:46');
INSERT INTO `icon` VALUES ('322', 'sitemap', 'fa-sitemap', '2019-02-18 10:41:47');
INSERT INTO `icon` VALUES ('323', 'sliders', 'fa-sliders', '2019-02-18 10:41:49');
INSERT INTO `icon` VALUES ('324', 'smile-o', 'fa-smile-o', '2019-02-18 10:41:50');
INSERT INTO `icon` VALUES ('325', 'sort', 'fa-sort', '2019-02-18 10:41:51');
INSERT INTO `icon` VALUES ('326', 'sort-alpha-asc', 'fa-sort-alpha-asc', '2019-02-18 10:41:52');
INSERT INTO `icon` VALUES ('327', 'sort-alpha-desc', 'fa-sort-alpha-desc', '2019-02-18 10:41:54');
INSERT INTO `icon` VALUES ('328', 'sort-amount-asc', 'fa-sort-amount-asc', '2019-02-18 10:41:55');
INSERT INTO `icon` VALUES ('329', 'sort-amount-desc', 'fa-sort-amount-desc', '2019-02-18 10:41:57');
INSERT INTO `icon` VALUES ('330', 'sort-asc', 'fa-sort-asc', '2019-02-18 10:41:58');
INSERT INTO `icon` VALUES ('331', 'sort-desc', 'fa-sort-desc', '2019-02-18 10:41:59');
INSERT INTO `icon` VALUES ('332', 'sort-numeric-asc', 'fa-sort-numeric-asc', '2019-02-18 10:42:01');
INSERT INTO `icon` VALUES ('333', 'sort-numeric-desc', 'fa-sort-numeric-desc', '2019-02-18 10:42:02');
INSERT INTO `icon` VALUES ('334', 'space-shuttle', 'fa-space-shuttle', '2019-02-18 10:42:03');
INSERT INTO `icon` VALUES ('335', 'spinner', 'fa-spinner', '2019-02-18 10:42:05');
INSERT INTO `icon` VALUES ('336', 'spoon', 'fa-spoon', '2019-02-18 10:42:06');
INSERT INTO `icon` VALUES ('337', 'square', 'fa-square', '2019-02-18 10:42:08');
INSERT INTO `icon` VALUES ('338', 'square-o', 'fa-square-o', '2019-02-18 10:42:09');
INSERT INTO `icon` VALUES ('339', 'star', 'fa-star', '2019-02-18 10:42:10');
INSERT INTO `icon` VALUES ('340', 'star-half', 'fa-star-half', '2019-02-18 10:42:12');
INSERT INTO `icon` VALUES ('341', 'star-half-o', 'fa-star-half-o', '2019-02-18 10:42:13');
INSERT INTO `icon` VALUES ('342', 'star-o', 'fa-star-o', '2019-02-18 10:42:14');
INSERT INTO `icon` VALUES ('343', 'sticky-note', 'fa-sticky-note', '2019-02-18 10:42:16');
INSERT INTO `icon` VALUES ('344', 'sticky-note-o', 'fa-sticky-note-o', '2019-02-18 10:42:17');
INSERT INTO `icon` VALUES ('345', 'street-view', 'fa-street-view', '2019-02-18 10:42:18');
INSERT INTO `icon` VALUES ('346', 'suitcase', 'fa-suitcase', '2019-02-18 10:42:20');
INSERT INTO `icon` VALUES ('347', 'sun-o', 'fa-sun-o', '2019-02-18 10:42:21');
INSERT INTO `icon` VALUES ('348', 'tablet', 'fa-tablet', '2019-02-18 10:42:23');
INSERT INTO `icon` VALUES ('349', 'tag', 'fa-tag', '2019-02-18 10:42:24');
INSERT INTO `icon` VALUES ('350', 'tags', 'fa-tags', '2019-02-18 10:42:25');
INSERT INTO `icon` VALUES ('351', 'tasks', 'fa-tasks', '2019-02-18 10:42:27');
INSERT INTO `icon` VALUES ('352', 'television', 'fa-television', '2019-02-18 10:42:28');
INSERT INTO `icon` VALUES ('353', 'terminal', 'fa-terminal', '2019-02-18 10:42:29');
INSERT INTO `icon` VALUES ('354', 'thumb-tack', 'fa-thumb-tack', '2019-02-18 10:42:31');
INSERT INTO `icon` VALUES ('355', 'thumbs-down', 'fa-thumbs-down', '2019-02-18 10:42:32');
INSERT INTO `icon` VALUES ('356', 'thumbs-o-down', 'fa-thumbs-o-down', '2019-02-18 10:42:34');
INSERT INTO `icon` VALUES ('357', 'thumbs-o-up', 'fa-thumbs-o-up', '2019-02-18 10:42:35');
INSERT INTO `icon` VALUES ('358', 'thumbs-up', 'fa-thumbs-up', '2019-02-18 10:42:36');
INSERT INTO `icon` VALUES ('359', 'ticket', 'fa-ticket', '2019-02-18 10:42:38');
INSERT INTO `icon` VALUES ('360', 'times-circle', 'fa-times-circle', '2019-02-18 10:42:39');
INSERT INTO `icon` VALUES ('361', 'times-circle-o', 'fa-times-circle-o', '2019-02-18 10:42:40');
INSERT INTO `icon` VALUES ('362', 'tint', 'fa-tint', '2019-02-18 10:42:42');
INSERT INTO `icon` VALUES ('363', 'toggle-off', 'fa-toggle-off', '2019-02-18 10:42:43');
INSERT INTO `icon` VALUES ('364', 'toggle-on', 'fa-toggle-on', '2019-02-18 10:42:45');
INSERT INTO `icon` VALUES ('365', 'trademark', 'fa-trademark', '2019-02-18 10:42:46');
INSERT INTO `icon` VALUES ('366', 'trash', 'fa-trash', '2019-02-18 10:42:47');
INSERT INTO `icon` VALUES ('367', 'trash-o', 'fa-trash-o', '2019-02-18 10:42:49');
INSERT INTO `icon` VALUES ('368', 'tree', 'fa-tree', '2019-02-18 10:42:50');
INSERT INTO `icon` VALUES ('369', 'trophy', 'fa-trophy', '2019-02-18 10:42:51');
INSERT INTO `icon` VALUES ('370', 'truck', 'fa-truck', '2019-02-18 10:42:53');
INSERT INTO `icon` VALUES ('371', 'tty', 'fa-tty', '2019-02-18 10:42:54');
INSERT INTO `icon` VALUES ('372', 'umbrella', 'fa-umbrella', '2019-02-18 10:42:55');
INSERT INTO `icon` VALUES ('373', 'universal-access', 'fa-universal-access', '2019-02-18 10:42:57');
INSERT INTO `icon` VALUES ('374', 'unlock', 'fa-unlock', '2019-02-18 10:42:58');
INSERT INTO `icon` VALUES ('375', 'unlock-alt', 'fa-unlock-alt', '2019-02-18 10:42:59');
INSERT INTO `icon` VALUES ('376', 'upload', 'fa-upload', '2019-02-18 10:43:01');
INSERT INTO `icon` VALUES ('377', 'user', 'fa-user', '2019-02-18 10:43:02');
INSERT INTO `icon` VALUES ('378', 'user-plus', 'fa-user-plus', '2019-02-18 10:43:03');
INSERT INTO `icon` VALUES ('379', 'user-secret', 'fa-user-secret', '2019-02-18 10:43:05');
INSERT INTO `icon` VALUES ('380', 'user-times', 'fa-user-times', '2019-02-18 10:43:06');
INSERT INTO `icon` VALUES ('381', 'video-camera', 'fa-video-camera', '2019-02-18 10:43:07');
INSERT INTO `icon` VALUES ('382', 'volume-control-phone', 'fa-volume-control-phone', '2019-02-18 10:43:09');
INSERT INTO `icon` VALUES ('383', 'volume-down', 'fa-volume-down', '2019-02-18 10:43:10');
INSERT INTO `icon` VALUES ('384', 'volume-off', 'fa-volume-off', '2019-02-18 10:43:12');
INSERT INTO `icon` VALUES ('385', 'volume-up', 'fa-volume-up', '2019-02-18 10:43:13');
INSERT INTO `icon` VALUES ('386', 'wheelchair', 'fa-wheelchair', '2019-02-18 10:43:14');
INSERT INTO `icon` VALUES ('387', 'wheelchair-alt', 'fa-wheelchair-alt', '2019-02-18 10:43:16');
INSERT INTO `icon` VALUES ('388', 'wifi', 'fa-wifi', '2019-02-18 10:43:17');
INSERT INTO `icon` VALUES ('389', 'wrench', 'fa-wrench', '2019-02-18 10:43:19');
INSERT INTO `icon` VALUES ('390', 'hand-o-down', 'fa-hand-o-down', '2019-02-18 10:43:20');
INSERT INTO `icon` VALUES ('391', 'hand-o-left', 'fa-hand-o-left', '2019-02-18 10:43:21');
INSERT INTO `icon` VALUES ('392', 'hand-o-right', 'fa-hand-o-right', '2019-02-18 10:43:23');
INSERT INTO `icon` VALUES ('393', 'hand-o-up', 'fa-hand-o-up', '2019-02-18 10:43:24');
INSERT INTO `icon` VALUES ('394', 'ambulance', 'fa-ambulance', '2019-02-18 10:43:25');
INSERT INTO `icon` VALUES ('395', 'subway', 'fa-subway', '2019-02-18 10:43:27');
INSERT INTO `icon` VALUES ('396', 'train', 'fa-train', '2019-02-18 10:43:28');
INSERT INTO `icon` VALUES ('397', 'genderless', 'fa-genderless', '2019-02-18 10:43:30');
INSERT INTO `icon` VALUES ('398', 'transgender', 'fa-transgender', '2019-02-18 10:43:31');
INSERT INTO `icon` VALUES ('399', 'mars', 'fa-mars', '2019-02-18 10:43:32');
INSERT INTO `icon` VALUES ('400', 'mars-double', 'fa-mars-double', '2019-02-18 10:43:34');
INSERT INTO `icon` VALUES ('401', 'mars-stroke', 'fa-mars-stroke', '2019-02-18 10:43:35');
INSERT INTO `icon` VALUES ('402', 'mars-stroke-h', 'fa-mars-stroke-h', '2019-02-18 10:43:36');
INSERT INTO `icon` VALUES ('403', 'mars-stroke-v', 'fa-mars-stroke-v', '2019-02-18 10:43:38');
INSERT INTO `icon` VALUES ('404', 'mercury', 'fa-mercury', '2019-02-18 10:43:39');
INSERT INTO `icon` VALUES ('405', 'neuter', 'fa-neuter', '2019-02-18 10:43:40');
INSERT INTO `icon` VALUES ('406', 'transgender-alt', 'fa-transgender-alt', '2019-02-18 10:43:42');
INSERT INTO `icon` VALUES ('407', 'venus', 'fa-venus', '2019-02-18 10:43:43');
INSERT INTO `icon` VALUES ('408', 'venus-double', 'fa-venus-double', '2019-02-18 10:43:44');
INSERT INTO `icon` VALUES ('409', 'venus-mars', 'fa-venus-mars', '2019-02-18 10:43:46');
INSERT INTO `icon` VALUES ('410', 'file', 'fa-file', '2019-02-18 10:43:47');
INSERT INTO `icon` VALUES ('411', 'file-o', 'fa-file-o', '2019-02-18 10:43:48');
INSERT INTO `icon` VALUES ('412', 'file-text', 'fa-file-text', '2019-02-18 10:43:50');
INSERT INTO `icon` VALUES ('413', 'file-text-o', 'fa-file-text-o', '2019-02-18 10:43:51');
INSERT INTO `icon` VALUES ('414', 'cc-amex', 'fa-cc-amex', '2019-02-18 10:43:53');
INSERT INTO `icon` VALUES ('415', 'cc-diners-club', 'fa-cc-diners-club', '2019-02-18 10:43:54');
INSERT INTO `icon` VALUES ('416', 'cc-discover', 'fa-cc-discover', '2019-02-18 10:43:55');
INSERT INTO `icon` VALUES ('417', 'cc-jcb', 'fa-cc-jcb', '2019-02-18 10:43:57');
INSERT INTO `icon` VALUES ('418', 'cc-mastercard', 'fa-cc-mastercard', '2019-02-18 10:43:58');
INSERT INTO `icon` VALUES ('419', 'cc-paypal', 'fa-cc-paypal', '2019-02-18 10:43:59');
INSERT INTO `icon` VALUES ('420', 'cc-stripe', 'fa-cc-stripe', '2019-02-18 10:44:01');
INSERT INTO `icon` VALUES ('421', 'cc-visa', 'fa-cc-visa', '2019-02-18 10:44:02');
INSERT INTO `icon` VALUES ('422', 'google-wallet', 'fa-google-wallet', '2019-02-18 10:44:04');
INSERT INTO `icon` VALUES ('423', 'paypal', 'fa-paypal', '2019-02-18 10:44:05');
INSERT INTO `icon` VALUES ('424', 'btc', 'fa-btc', '2019-02-18 10:44:06');
INSERT INTO `icon` VALUES ('425', 'jpy', 'fa-jpy', '2019-02-18 10:44:08');
INSERT INTO `icon` VALUES ('426', 'usd', 'fa-usd', '2019-02-18 10:44:09');
INSERT INTO `icon` VALUES ('427', 'eur', 'fa-eur', '2019-02-18 10:44:10');
INSERT INTO `icon` VALUES ('428', 'gbp', 'fa-gbp', '2019-02-18 10:44:12');
INSERT INTO `icon` VALUES ('429', 'gg', 'fa-gg', '2019-02-18 10:44:13');
INSERT INTO `icon` VALUES ('430', 'gg-circle', 'fa-gg-circle', '2019-02-18 10:44:15');
INSERT INTO `icon` VALUES ('431', 'ils', 'fa-ils', '2019-02-18 10:44:16');
INSERT INTO `icon` VALUES ('432', 'inr', 'fa-inr', '2019-02-18 10:44:17');
INSERT INTO `icon` VALUES ('433', 'krw', 'fa-krw', '2019-02-18 10:44:19');
INSERT INTO `icon` VALUES ('434', 'rub', 'fa-rub', '2019-02-18 10:44:20');
INSERT INTO `icon` VALUES ('435', 'try', 'fa-try', '2019-02-18 10:44:21');
INSERT INTO `icon` VALUES ('436', 'align-center', 'fa-align-center', '2019-02-18 10:44:23');
INSERT INTO `icon` VALUES ('437', 'align-justify', 'fa-align-justify', '2019-02-18 10:44:24');
INSERT INTO `icon` VALUES ('438', 'align-left', 'fa-align-left', '2019-02-18 10:44:26');
INSERT INTO `icon` VALUES ('439', 'align-right', 'fa-align-right', '2019-02-18 10:44:27');
INSERT INTO `icon` VALUES ('440', 'bold', 'fa-bold', '2019-02-18 10:44:28');
INSERT INTO `icon` VALUES ('441', 'link', 'fa-link', '2019-02-18 10:44:30');
INSERT INTO `icon` VALUES ('442', 'chain-broken', 'fa-chain-broken', '2019-02-18 10:44:31');
INSERT INTO `icon` VALUES ('443', 'clipboard', 'fa-clipboard', '2019-02-18 10:44:32');
INSERT INTO `icon` VALUES ('444', 'columns', 'fa-columns', '2019-02-18 10:44:34');
INSERT INTO `icon` VALUES ('445', 'files-o', 'fa-files-o', '2019-02-18 10:44:35');
INSERT INTO `icon` VALUES ('446', 'scissors', 'fa-scissors', '2019-02-18 10:44:36');
INSERT INTO `icon` VALUES ('447', 'outdent', 'fa-outdent', '2019-02-18 10:44:38');
INSERT INTO `icon` VALUES ('448', 'floppy-o', 'fa-floppy-o', '2019-02-18 10:44:39');
INSERT INTO `icon` VALUES ('449', 'font', 'fa-font', '2019-02-18 10:44:40');
INSERT INTO `icon` VALUES ('450', 'header', 'fa-header', '2019-02-18 10:44:42');
INSERT INTO `icon` VALUES ('451', 'indent', 'fa-indent', '2019-02-18 10:44:43');
INSERT INTO `icon` VALUES ('452', 'italic', 'fa-italic', '2019-02-18 10:44:45');
INSERT INTO `icon` VALUES ('453', 'list', 'fa-list', '2019-02-18 10:44:46');
INSERT INTO `icon` VALUES ('454', 'list-alt', 'fa-list-alt', '2019-02-18 10:44:47');
INSERT INTO `icon` VALUES ('455', 'list-ol', 'fa-list-ol', '2019-02-18 10:44:49');
INSERT INTO `icon` VALUES ('456', 'list-ul', 'fa-list-ul', '2019-02-18 10:44:50');
INSERT INTO `icon` VALUES ('457', 'paperclip', 'fa-paperclip', '2019-02-18 10:44:51');
INSERT INTO `icon` VALUES ('458', 'paragraph', 'fa-paragraph', '2019-02-18 10:44:53');
INSERT INTO `icon` VALUES ('459', 'repeat', 'fa-repeat', '2019-02-18 10:44:54');
INSERT INTO `icon` VALUES ('460', 'undo', 'fa-undo', '2019-02-18 10:44:55');
INSERT INTO `icon` VALUES ('461', 'strikethrough', 'fa-strikethrough', '2019-02-18 10:44:57');
INSERT INTO `icon` VALUES ('462', 'subscript', 'fa-subscript', '2019-02-18 10:44:58');
INSERT INTO `icon` VALUES ('463', 'superscript', 'fa-superscript', '2019-02-18 10:45:00');
INSERT INTO `icon` VALUES ('464', 'table', 'fa-table', '2019-02-18 10:45:01');
INSERT INTO `icon` VALUES ('465', 'text-height', 'fa-text-height', '2019-02-18 10:45:02');
INSERT INTO `icon` VALUES ('466', 'text-width', 'fa-text-width', '2019-02-18 10:45:04');
INSERT INTO `icon` VALUES ('467', 'th', 'fa-th', '2019-02-18 10:45:05');
INSERT INTO `icon` VALUES ('468', 'th-large', 'fa-th-large', '2019-02-18 10:45:06');
INSERT INTO `icon` VALUES ('469', 'th-list', 'fa-th-list', '2019-02-18 10:45:08');
INSERT INTO `icon` VALUES ('470', 'underline', 'fa-underline', '2019-02-18 10:45:09');
INSERT INTO `icon` VALUES ('471', 'angle-double-down', 'fa-angle-double-down', '2019-02-18 10:45:10');
INSERT INTO `icon` VALUES ('472', 'angle-double-left', 'fa-angle-double-left', '2019-02-18 10:45:12');
INSERT INTO `icon` VALUES ('473', 'angle-double-right', 'fa-angle-double-right', '2019-02-18 10:45:13');
INSERT INTO `icon` VALUES ('474', 'angle-double-up', 'fa-angle-double-up', '2019-02-18 10:45:14');
INSERT INTO `icon` VALUES ('475', 'angle-down', 'fa-angle-down', '2019-02-18 10:45:16');
INSERT INTO `icon` VALUES ('476', 'angle-left', 'fa-angle-left', '2019-02-18 10:45:17');
INSERT INTO `icon` VALUES ('477', 'angle-right', 'fa-angle-right', '2019-02-18 10:45:18');
INSERT INTO `icon` VALUES ('478', 'angle-up', 'fa-angle-up', '2019-02-18 10:45:20');
INSERT INTO `icon` VALUES ('479', 'arrow-circle-down', 'fa-arrow-circle-down', '2019-02-18 10:45:21');
INSERT INTO `icon` VALUES ('480', 'arrow-circle-left', 'fa-arrow-circle-left', '2019-02-18 10:45:23');
INSERT INTO `icon` VALUES ('481', 'arrow-circle-o-down', 'fa-arrow-circle-o-down', '2019-02-18 10:45:24');
INSERT INTO `icon` VALUES ('482', 'arrow-circle-o-left', 'fa-arrow-circle-o-left', '2019-02-18 10:45:25');
INSERT INTO `icon` VALUES ('483', 'arrow-circle-o-right', 'fa-arrow-circle-o-right', '2019-02-18 10:45:27');
INSERT INTO `icon` VALUES ('484', 'arrow-circle-o-up', 'fa-arrow-circle-o-up', '2019-02-18 10:45:28');
INSERT INTO `icon` VALUES ('485', 'arrow-circle-right', 'fa-arrow-circle-right', '2019-02-18 10:45:29');
INSERT INTO `icon` VALUES ('486', 'arrow-circle-up', 'fa-arrow-circle-up', '2019-02-18 10:45:31');
INSERT INTO `icon` VALUES ('487', 'arrow-down', 'fa-arrow-down', '2019-02-18 10:45:32');
INSERT INTO `icon` VALUES ('488', 'arrow-left', 'fa-arrow-left', '2019-02-18 10:45:33');
INSERT INTO `icon` VALUES ('489', 'arrow-right', 'fa-arrow-right', '2019-02-18 10:45:35');
INSERT INTO `icon` VALUES ('490', 'arrow-up', 'fa-arrow-up', '2019-02-18 10:45:36');
INSERT INTO `icon` VALUES ('491', 'arrows-alt', 'fa-arrows-alt', '2019-02-18 10:45:38');
INSERT INTO `icon` VALUES ('492', 'caret-down', 'fa-caret-down', '2019-02-18 10:45:39');
INSERT INTO `icon` VALUES ('493', 'caret-left', 'fa-caret-left', '2019-02-18 10:45:41');
INSERT INTO `icon` VALUES ('494', 'caret-right', 'fa-caret-right', '2019-02-18 10:45:42');
INSERT INTO `icon` VALUES ('495', 'caret-up', 'fa-caret-up', '2019-02-18 10:45:43');
INSERT INTO `icon` VALUES ('496', 'chevron-circle-down', 'fa-chevron-circle-down', '2019-02-18 10:45:45');
INSERT INTO `icon` VALUES ('497', 'chevron-circle-left', 'fa-chevron-circle-left', '2019-02-18 10:45:46');
INSERT INTO `icon` VALUES ('498', 'chevron-circle-right', 'fa-chevron-circle-right', '2019-02-18 10:45:47');
INSERT INTO `icon` VALUES ('499', 'chevron-circle-up', 'fa-chevron-circle-up', '2019-02-18 10:45:49');
INSERT INTO `icon` VALUES ('500', 'chevron-down', 'fa-chevron-down', '2019-02-18 10:45:50');
INSERT INTO `icon` VALUES ('501', 'chevron-left', 'fa-chevron-left', '2019-02-18 10:45:51');
INSERT INTO `icon` VALUES ('502', 'chevron-right', 'fa-chevron-right', '2019-02-18 10:45:53');
INSERT INTO `icon` VALUES ('503', 'chevron-up', 'fa-chevron-up', '2019-02-18 10:45:54');
INSERT INTO `icon` VALUES ('504', 'long-arrow-down', 'fa-long-arrow-down', '2019-02-18 10:45:56');
INSERT INTO `icon` VALUES ('505', 'long-arrow-left', 'fa-long-arrow-left', '2019-02-18 10:45:57');
INSERT INTO `icon` VALUES ('506', 'long-arrow-right', 'fa-long-arrow-right', '2019-02-18 10:45:58');
INSERT INTO `icon` VALUES ('507', 'long-arrow-up', 'fa-long-arrow-up', '2019-02-18 10:46:00');
INSERT INTO `icon` VALUES ('508', 'backward', 'fa-backward', '2019-02-18 10:46:01');
INSERT INTO `icon` VALUES ('509', 'compress', 'fa-compress', '2019-02-18 10:46:02');
INSERT INTO `icon` VALUES ('510', 'eject', 'fa-eject', '2019-02-18 10:46:04');
INSERT INTO `icon` VALUES ('511', 'expand', 'fa-expand', '2019-02-18 10:46:05');
INSERT INTO `icon` VALUES ('512', 'fast-backward', 'fa-fast-backward', '2019-02-18 10:46:06');
INSERT INTO `icon` VALUES ('513', 'fast-forward', 'fa-fast-forward', '2019-02-18 10:46:08');
INSERT INTO `icon` VALUES ('514', 'forward', 'fa-forward', '2019-02-18 10:46:09');
INSERT INTO `icon` VALUES ('515', 'pause', 'fa-pause', '2019-02-18 10:46:10');
INSERT INTO `icon` VALUES ('516', 'pause-circle', 'fa-pause-circle', '2019-02-18 10:46:12');
INSERT INTO `icon` VALUES ('517', 'pause-circle-o', 'fa-pause-circle-o', '2019-02-18 10:46:13');
INSERT INTO `icon` VALUES ('518', 'play', 'fa-play', '2019-02-18 10:46:14');
INSERT INTO `icon` VALUES ('519', 'play-circle', 'fa-play-circle', '2019-02-18 10:46:16');
INSERT INTO `icon` VALUES ('520', 'play-circle-o', 'fa-play-circle-o', '2019-02-18 10:46:17');
INSERT INTO `icon` VALUES ('521', 'step-backward', 'fa-step-backward', '2019-02-18 10:46:18');
INSERT INTO `icon` VALUES ('522', 'step-forward', 'fa-step-forward', '2019-02-18 10:46:20');
INSERT INTO `icon` VALUES ('523', 'stop', 'fa-stop', '2019-02-18 10:46:21');
INSERT INTO `icon` VALUES ('524', 'stop-circle', 'fa-stop-circle', '2019-02-18 10:46:22');
INSERT INTO `icon` VALUES ('525', 'stop-circle-o', 'fa-stop-circle-o', '2019-02-18 10:46:24');
INSERT INTO `icon` VALUES ('526', 'youtube-play', 'fa-youtube-play', '2019-02-18 10:46:25');
INSERT INTO `icon` VALUES ('527', 'adn', 'fa-adn', '2019-02-18 10:46:28');
INSERT INTO `icon` VALUES ('528', 'android', 'fa-android', '2019-02-18 10:46:30');
INSERT INTO `icon` VALUES ('529', 'angellist', 'fa-angellist', '2019-02-18 10:46:32');
INSERT INTO `icon` VALUES ('530', 'apple', 'fa-apple', '2019-02-18 10:46:33');
INSERT INTO `icon` VALUES ('531', 'behance', 'fa-behance', '2019-02-18 10:46:35');
INSERT INTO `icon` VALUES ('532', 'behance-square', 'fa-behance-square', '2019-02-18 10:46:36');
INSERT INTO `icon` VALUES ('533', 'bitbucket', 'fa-bitbucket', '2019-02-18 10:46:37');
INSERT INTO `icon` VALUES ('534', 'bitbucket-square', 'fa-bitbucket-square', '2019-02-18 10:46:39');
INSERT INTO `icon` VALUES ('535', 'black-tie', 'fa-black-tie', '2019-02-18 10:46:40');
INSERT INTO `icon` VALUES ('536', 'buysellads', 'fa-buysellads', '2019-02-18 10:46:41');
INSERT INTO `icon` VALUES ('537', 'chrome', 'fa-chrome', '2019-02-18 10:46:43');
INSERT INTO `icon` VALUES ('538', 'codepen', 'fa-codepen', '2019-02-18 10:46:44');
INSERT INTO `icon` VALUES ('539', 'codiepie', 'fa-codiepie', '2019-02-18 10:46:46');
INSERT INTO `icon` VALUES ('540', 'connectdevelop', 'fa-connectdevelop', '2019-02-18 10:46:47');
INSERT INTO `icon` VALUES ('541', 'contao', 'fa-contao', '2019-02-18 10:46:48');
INSERT INTO `icon` VALUES ('542', 'css3', 'fa-css3', '2019-02-18 10:46:50');
INSERT INTO `icon` VALUES ('543', 'dashcube', 'fa-dashcube', '2019-02-18 10:46:51');
INSERT INTO `icon` VALUES ('544', 'delicious', 'fa-delicious', '2019-02-18 10:46:53');
INSERT INTO `icon` VALUES ('545', 'deviantart', 'fa-deviantart', '2019-02-18 10:46:54');
INSERT INTO `icon` VALUES ('546', 'digg', 'fa-digg', '2019-02-18 10:46:55');
INSERT INTO `icon` VALUES ('547', 'dribbble', 'fa-dribbble', '2019-02-18 10:46:57');
INSERT INTO `icon` VALUES ('548', 'dropbox', 'fa-dropbox', '2019-02-18 10:46:58');
INSERT INTO `icon` VALUES ('549', 'drupal', 'fa-drupal', '2019-02-18 10:47:00');
INSERT INTO `icon` VALUES ('550', 'edge', 'fa-edge', '2019-02-18 10:47:01');
INSERT INTO `icon` VALUES ('551', 'empire', 'fa-empire', '2019-02-18 10:47:02');
INSERT INTO `icon` VALUES ('552', 'envira', 'fa-envira', '2019-02-18 10:47:04');
INSERT INTO `icon` VALUES ('553', 'expeditedssl', 'fa-expeditedssl', '2019-02-18 10:47:05');
INSERT INTO `icon` VALUES ('554', 'font-awesome', 'fa-font-awesome', '2019-02-18 10:47:06');
INSERT INTO `icon` VALUES ('555', 'facebook', 'fa-facebook', '2019-02-18 10:47:08');
INSERT INTO `icon` VALUES ('556', 'facebook-official', 'fa-facebook-official', '2019-02-18 10:47:09');
INSERT INTO `icon` VALUES ('557', 'facebook-square', 'fa-facebook-square', '2019-02-18 10:47:10');
INSERT INTO `icon` VALUES ('558', 'firefox', 'fa-firefox', '2019-02-18 10:47:12');
INSERT INTO `icon` VALUES ('559', 'first-order', 'fa-first-order', '2019-02-18 10:47:13');
INSERT INTO `icon` VALUES ('560', 'flickr', 'fa-flickr', '2019-02-18 10:47:14');
INSERT INTO `icon` VALUES ('561', 'fonticons', 'fa-fonticons', '2019-02-18 10:47:16');
INSERT INTO `icon` VALUES ('562', 'fort-awesome', 'fa-fort-awesome', '2019-02-18 10:47:17');
INSERT INTO `icon` VALUES ('563', 'forumbee', 'fa-forumbee', '2019-02-18 10:47:18');
INSERT INTO `icon` VALUES ('564', 'foursquare', 'fa-foursquare', '2019-02-18 10:47:20');
INSERT INTO `icon` VALUES ('565', 'get-pocket', 'fa-get-pocket', '2019-02-18 10:47:21');
INSERT INTO `icon` VALUES ('566', 'git', 'fa-git', '2019-02-18 10:47:23');
INSERT INTO `icon` VALUES ('567', 'git-square', 'fa-git-square', '2019-02-18 10:47:24');
INSERT INTO `icon` VALUES ('568', 'github', 'fa-github', '2019-02-18 10:47:25');
INSERT INTO `icon` VALUES ('569', 'github-alt', 'fa-github-alt', '2019-02-18 10:47:27');
INSERT INTO `icon` VALUES ('570', 'github-square', 'fa-github-square', '2019-02-18 10:47:28');
INSERT INTO `icon` VALUES ('571', 'gitlab', 'fa-gitlab', '2019-02-18 10:47:29');
INSERT INTO `icon` VALUES ('572', 'gratipay', 'fa-gratipay', '2019-02-18 10:47:31');
INSERT INTO `icon` VALUES ('573', 'glide', 'fa-glide', '2019-02-18 10:47:32');
INSERT INTO `icon` VALUES ('574', 'glide-g', 'fa-glide-g', '2019-02-18 10:47:33');
INSERT INTO `icon` VALUES ('575', 'google', 'fa-google', '2019-02-18 10:47:35');
INSERT INTO `icon` VALUES ('576', 'google-plus', 'fa-google-plus', '2019-02-18 10:47:36');
INSERT INTO `icon` VALUES ('577', 'google-plus-official', 'fa-google-plus-official', '2019-02-18 10:47:37');
INSERT INTO `icon` VALUES ('578', 'google-plus-square', 'fa-google-plus-square', '2019-02-18 10:47:39');
INSERT INTO `icon` VALUES ('579', 'hacker-news', 'fa-hacker-news', '2019-02-18 10:47:40');
INSERT INTO `icon` VALUES ('580', 'houzz', 'fa-houzz', '2019-02-18 10:47:41');
INSERT INTO `icon` VALUES ('581', 'html5', 'fa-html5', '2019-02-18 10:47:43');
INSERT INTO `icon` VALUES ('582', 'instagram', 'fa-instagram', '2019-02-18 10:47:44');
INSERT INTO `icon` VALUES ('583', 'internet-explorer', 'fa-internet-explorer', '2019-02-18 10:47:46');
INSERT INTO `icon` VALUES ('584', 'ioxhost', 'fa-ioxhost', '2019-02-18 10:47:47');
INSERT INTO `icon` VALUES ('585', 'joomla', 'fa-joomla', '2019-02-18 10:47:48');
INSERT INTO `icon` VALUES ('586', 'jsfiddle', 'fa-jsfiddle', '2019-02-18 10:47:50');
INSERT INTO `icon` VALUES ('587', 'lastfm', 'fa-lastfm', '2019-02-18 10:47:51');
INSERT INTO `icon` VALUES ('588', 'lastfm-square', 'fa-lastfm-square', '2019-02-18 10:47:52');
INSERT INTO `icon` VALUES ('589', 'leanpub', 'fa-leanpub', '2019-02-18 10:47:54');
INSERT INTO `icon` VALUES ('590', 'linkedin', 'fa-linkedin', '2019-02-18 10:47:55');
INSERT INTO `icon` VALUES ('591', 'linkedin-square', 'fa-linkedin-square', '2019-02-18 10:47:56');
INSERT INTO `icon` VALUES ('592', 'linux', 'fa-linux', '2019-02-18 10:47:58');
INSERT INTO `icon` VALUES ('593', 'maxcdn', 'fa-maxcdn', '2019-02-18 10:47:59');
INSERT INTO `icon` VALUES ('594', 'meanpath', 'fa-meanpath', '2019-02-18 10:48:00');
INSERT INTO `icon` VALUES ('595', 'medium', 'fa-medium', '2019-02-18 10:48:02');
INSERT INTO `icon` VALUES ('596', 'mixcloud', 'fa-mixcloud', '2019-02-18 10:48:03');
INSERT INTO `icon` VALUES ('597', 'modx', 'fa-modx', '2019-02-18 10:48:04');
INSERT INTO `icon` VALUES ('598', 'odnoklassniki', 'fa-odnoklassniki', '2019-02-18 10:48:06');
INSERT INTO `icon` VALUES ('599', 'odnoklassniki-square', 'fa-odnoklassniki-square', '2019-02-18 10:48:07');
INSERT INTO `icon` VALUES ('600', 'opencart', 'fa-opencart', '2019-02-18 10:48:08');
INSERT INTO `icon` VALUES ('601', 'openid', 'fa-openid', '2019-02-18 10:48:10');
INSERT INTO `icon` VALUES ('602', 'opera', 'fa-opera', '2019-02-18 10:48:11');
INSERT INTO `icon` VALUES ('603', 'optin-monster', 'fa-optin-monster', '2019-02-18 10:48:12');
INSERT INTO `icon` VALUES ('604', 'pagelines', 'fa-pagelines', '2019-02-18 10:48:14');
INSERT INTO `icon` VALUES ('605', 'pied-piper', 'fa-pied-piper', '2019-02-18 10:48:15');
INSERT INTO `icon` VALUES ('606', 'pied-piper-alt', 'fa-pied-piper-alt', '2019-02-18 10:48:16');
INSERT INTO `icon` VALUES ('607', 'pinterest', 'fa-pinterest', '2019-02-18 10:48:19');
INSERT INTO `icon` VALUES ('608', 'pinterest-p', 'fa-pinterest-p', '2019-02-18 10:48:20');
INSERT INTO `icon` VALUES ('609', 'pinterest-square', 'fa-pinterest-square', '2019-02-18 10:48:22');
INSERT INTO `icon` VALUES ('610', 'product-hunt', 'fa-product-hunt', '2019-02-18 10:48:23');
INSERT INTO `icon` VALUES ('611', 'qq', 'fa-qq', '2019-02-18 10:48:24');
INSERT INTO `icon` VALUES ('612', 'rebel', 'fa-rebel', '2019-02-18 10:48:26');
INSERT INTO `icon` VALUES ('613', 'reddit', 'fa-reddit', '2019-02-18 10:48:27');
INSERT INTO `icon` VALUES ('614', 'reddit-alien', 'fa-reddit-alien', '2019-02-18 10:48:28');
INSERT INTO `icon` VALUES ('615', 'reddit-square', 'fa-reddit-square', '2019-02-18 10:48:30');
INSERT INTO `icon` VALUES ('616', 'renren', 'fa-renren', '2019-02-18 10:48:31');
INSERT INTO `icon` VALUES ('617', 'safari', 'fa-safari', '2019-02-18 10:48:32');
INSERT INTO `icon` VALUES ('618', 'scribd', 'fa-scribd', '2019-02-18 10:48:34');
INSERT INTO `icon` VALUES ('619', 'sellsy', 'fa-sellsy', '2019-02-18 10:48:35');
INSERT INTO `icon` VALUES ('620', 'shirtsinbulk', 'fa-shirtsinbulk', '2019-02-18 10:48:37');
INSERT INTO `icon` VALUES ('621', 'simplybuilt', 'fa-simplybuilt', '2019-02-18 10:48:38');
INSERT INTO `icon` VALUES ('622', 'skyatlas', 'fa-skyatlas', '2019-02-18 10:48:40');
INSERT INTO `icon` VALUES ('623', 'skype', 'fa-skype', '2019-02-18 10:48:41');
INSERT INTO `icon` VALUES ('624', 'slack', 'fa-slack', '2019-02-18 10:48:42');
INSERT INTO `icon` VALUES ('625', 'slideshare', 'fa-slideshare', '2019-02-18 10:48:44');
INSERT INTO `icon` VALUES ('626', 'snapchat', 'fa-snapchat', '2019-02-18 10:48:45');
INSERT INTO `icon` VALUES ('627', 'snapchat-ghost', 'fa-snapchat-ghost', '2019-02-18 10:48:47');
INSERT INTO `icon` VALUES ('628', 'snapchat-square', 'fa-snapchat-square', '2019-02-18 10:48:48');
INSERT INTO `icon` VALUES ('629', 'soundcloud', 'fa-soundcloud', '2019-02-18 10:48:49');
INSERT INTO `icon` VALUES ('630', 'spotify', 'fa-spotify', '2019-02-18 10:48:51');
INSERT INTO `icon` VALUES ('631', 'stack-exchange', 'fa-stack-exchange', '2019-02-18 10:48:52');
INSERT INTO `icon` VALUES ('632', 'stack-overflow', 'fa-stack-overflow', '2019-02-18 10:48:54');
INSERT INTO `icon` VALUES ('633', 'steam', 'fa-steam', '2019-02-18 10:48:55');
INSERT INTO `icon` VALUES ('634', 'steam-square', 'fa-steam-square', '2019-02-18 10:48:56');
INSERT INTO `icon` VALUES ('635', 'stumbleupon', 'fa-stumbleupon', '2019-02-18 10:48:58');
INSERT INTO `icon` VALUES ('636', 'stumbleupon-circle', 'fa-stumbleupon-circle', '2019-02-18 10:48:59');
INSERT INTO `icon` VALUES ('637', 'tencent-weibo', 'fa-tencent-weibo', '2019-02-18 10:49:01');
INSERT INTO `icon` VALUES ('638', 'themeisle', 'fa-themeisle', '2019-02-18 10:49:02');
INSERT INTO `icon` VALUES ('639', 'trello', 'fa-trello', '2019-02-18 10:49:03');
INSERT INTO `icon` VALUES ('640', 'tripadvisor', 'fa-tripadvisor', '2019-02-18 10:49:05');
INSERT INTO `icon` VALUES ('641', 'tumblr', 'fa-tumblr', '2019-02-18 10:49:06');
INSERT INTO `icon` VALUES ('642', 'tumblr-square', 'fa-tumblr-square', '2019-02-18 10:49:08');
INSERT INTO `icon` VALUES ('643', 'twitch', 'fa-twitch', '2019-02-18 10:49:09');
INSERT INTO `icon` VALUES ('644', 'twitter', 'fa-twitter', '2019-02-18 10:49:10');
INSERT INTO `icon` VALUES ('645', 'twitter-square', 'fa-twitter-square', '2019-02-18 10:49:12');
INSERT INTO `icon` VALUES ('646', 'usb', 'fa-usb', '2019-02-18 10:49:13');
INSERT INTO `icon` VALUES ('647', 'viacoin', 'fa-viacoin', '2019-02-18 10:49:14');
INSERT INTO `icon` VALUES ('648', 'viadeo', 'fa-viadeo', '2019-02-18 10:49:16');
INSERT INTO `icon` VALUES ('649', 'viadeo-square', 'fa-viadeo-square', '2019-02-18 10:49:17');
INSERT INTO `icon` VALUES ('650', 'vimeo', 'fa-vimeo', '2019-02-18 10:49:19');
INSERT INTO `icon` VALUES ('651', 'vimeo-square', 'fa-vimeo-square', '2019-02-18 10:49:20');
INSERT INTO `icon` VALUES ('652', 'vine', 'fa-vine', '2019-02-18 10:49:21');
INSERT INTO `icon` VALUES ('653', 'vk', 'fa-vk', '2019-02-18 10:49:23');
INSERT INTO `icon` VALUES ('654', 'weixin', 'fa-weixin', '2019-02-18 10:49:24');
INSERT INTO `icon` VALUES ('655', 'weibo', 'fa-weibo', '2019-02-18 10:49:25');
INSERT INTO `icon` VALUES ('656', 'whatsapp', 'fa-whatsapp', '2019-02-18 10:49:27');
INSERT INTO `icon` VALUES ('657', 'wikipedia-w', 'fa-wikipedia-w', '2019-02-18 10:49:28');
INSERT INTO `icon` VALUES ('658', 'windows', 'fa-windows', '2019-02-18 10:49:30');
INSERT INTO `icon` VALUES ('659', 'wordpress', 'fa-wordpress', '2019-02-18 10:49:31');
INSERT INTO `icon` VALUES ('660', 'wpbeginner', 'fa-wpbeginner', '2019-02-18 10:49:32');
INSERT INTO `icon` VALUES ('661', 'wpforms', 'fa-wpforms', '2019-02-18 10:49:34');
INSERT INTO `icon` VALUES ('662', 'xing', 'fa-xing', '2019-02-18 10:49:35');
INSERT INTO `icon` VALUES ('663', 'xing-square', 'fa-xing-square', '2019-02-18 10:49:37');
INSERT INTO `icon` VALUES ('664', 'y-combinator', 'fa-y-combinator', '2019-02-18 10:49:38');
INSERT INTO `icon` VALUES ('665', 'yahoo', 'fa-yahoo', '2019-02-18 10:49:40');
INSERT INTO `icon` VALUES ('666', 'yelp', 'fa-yelp', '2019-02-18 10:49:41');
INSERT INTO `icon` VALUES ('667', 'yoast', 'fa-yoast', '2019-02-18 10:49:42');
INSERT INTO `icon` VALUES ('668', 'youtube', 'fa-youtube', '2019-02-18 10:49:44');
INSERT INTO `icon` VALUES ('669', 'youtube-square', 'fa-youtube-square', '2019-02-18 10:49:45');
INSERT INTO `icon` VALUES ('670', 'h-square', 'fa-h-square', '2019-02-18 10:49:47');
INSERT INTO `icon` VALUES ('671', 'hospital-o', 'fa-hospital-o', '2019-02-18 10:49:48');
INSERT INTO `icon` VALUES ('672', 'medkit', 'fa-medkit', '2019-02-18 10:49:49');
INSERT INTO `icon` VALUES ('673', 'stethoscope', 'fa-stethoscope', '2019-02-18 10:49:51');
INSERT INTO `icon` VALUES ('674', 'user-md', 'fa-user-md', '2019-02-18 10:49:52');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL auto_increment,
  `supplier_name` varchar(255) default NULL COMMENT '供应商名称',
  `contact` varchar(255) default NULL COMMENT '联系人',
  `cellphone` varchar(20) default NULL COMMENT '手机号码',
  `email` varchar(255) default NULL COMMENT '邮箱地址',
  `telephone` varchar(255) default NULL COMMENT '联系电话',
  `address` varchar(255) default NULL COMMENT '地址',
  `remark` varchar(500) default NULL COMMENT '备注',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', '上海某加工厂', 'zhangsan', '111111', '111111@126.com', '020-13232143', '上海市', '', '2019-02-18 17:42:07', '2019-02-19 11:51:43');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL auto_increment,
  `resource_name` varchar(255) default NULL COMMENT '资源名称',
  `resource_type` int(11) default NULL COMMENT '资源类型,0:目录;1:菜单;2:按钮',
  `resource_code` varchar(255) default NULL COMMENT '资源,唯一标识code',
  `parent_id` bigint(20) default NULL COMMENT '父资源ID',
  `resource_url` varchar(255) default NULL COMMENT '资源url',
  `seq` int(11) default NULL COMMENT '排序',
  `icon` varchar(255) default NULL COMMENT '图标',
  `description` varchar(255) default NULL COMMENT '描述信息',
  `create_time` datetime default NULL,
  `update_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '系统管理', '0', 'system:manager', '0', '', '2', 'fa-cog', '系统管理', '2018-12-06 17:53:04', '2019-02-11 16:06:19');
INSERT INTO `sys_resource` VALUES ('2', '用户管理', '1', 'system:user:manager', '1', '/system/user/manager', '1', 'fa-users', '用户管理菜单项', '2018-12-06 17:54:17', '2019-02-18 15:55:06');
INSERT INTO `sys_resource` VALUES ('3', '角色管理', '1', 'system:role:manager', '1', '/system/role/manager', '2', 'fa-user-md', '角色管理菜单项', '2019-01-28 14:48:39', '2019-02-18 15:55:46');
INSERT INTO `sys_resource` VALUES ('4', '资源管理', '1', 'system:resource:manager', '1', '/system/resource/manager', '3', 'fa-file', '资源管理菜单项', '2019-01-28 14:49:37', '2019-02-18 15:54:23');
INSERT INTO `sys_resource` VALUES ('6', '基础配置', '0', 'setting:manager', '0', '', '1', 'fa-cogs', '基础数据', '2019-02-11 15:59:21', '2019-02-11 15:59:21');
INSERT INTO `sys_resource` VALUES ('7', '数据字典', '1', 'setting:dictionary:manager', '6', '/setting/dictionary/manager', '1', 'fa-list', '数据字典管理', '2019-02-11 16:05:07', '2019-02-11 16:05:07');
INSERT INTO `sys_resource` VALUES ('8', '供应商管理', '1', 'setting:supplier', '6', '/setting/supplier/manager', '2', 'fa-hand-paper-o', '', '2019-02-18 17:38:57', '2019-02-18 17:38:57');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_name` varchar(50) default NULL,
  `role_key` varchar(255) default NULL COMMENT '角色key',
  `role_type` int(2) default NULL COMMENT '角色类型 1：管理员；2：操作员',
  `description` varchar(255) default NULL COMMENT '描述信息',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', 'administrator', '1', '系统管理员', '2018-10-25 17:51:21', '2019-02-18 17:39:09');
INSERT INTO `sys_role` VALUES ('2', '业务经理', 'manager', '1', '业务经理', '2019-02-02 15:45:50', '2019-02-02 15:45:53');
INSERT INTO `sys_role` VALUES ('3', '操作员', 'user', '2', '一般操作人员', '2019-02-02 15:46:23', '2019-02-14 15:44:35');
INSERT INTO `sys_role` VALUES ('4', '测试人员', 'test', '1', '测试人员', '2019-02-08 19:08:56', '2019-02-08 19:09:00');

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_id` bigint(20) default NULL COMMENT '角色ID',
  `resource_id` bigint(20) default NULL COMMENT '资源ID',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `idx_role_resource` USING BTREE (`role_id`,`resource_id`),
  KEY `idx_role` USING BTREE (`role_id`),
  KEY `idx_resource` USING BTREE (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES ('27', '3', '1', '2019-02-14 15:44:35', '2019-02-14 15:44:35');
INSERT INTO `sys_role_resource` VALUES ('28', '3', '3', '2019-02-14 15:44:35', '2019-02-14 15:44:35');
INSERT INTO `sys_role_resource` VALUES ('29', '3', '4', '2019-02-14 15:44:35', '2019-02-14 15:44:35');
INSERT INTO `sys_role_resource` VALUES ('30', '1', '6', '2019-02-18 17:39:09', '2019-02-18 17:39:09');
INSERT INTO `sys_role_resource` VALUES ('31', '1', '7', '2019-02-18 17:39:09', '2019-02-18 17:39:09');
INSERT INTO `sys_role_resource` VALUES ('32', '1', '8', '2019-02-18 17:39:09', '2019-02-18 17:39:09');
INSERT INTO `sys_role_resource` VALUES ('33', '1', '1', '2019-02-18 17:39:09', '2019-02-18 17:39:09');
INSERT INTO `sys_role_resource` VALUES ('34', '1', '2', '2019-02-18 17:39:09', '2019-02-18 17:39:09');
INSERT INTO `sys_role_resource` VALUES ('35', '1', '3', '2019-02-18 17:39:09', '2019-02-18 17:39:09');
INSERT INTO `sys_role_resource` VALUES ('36', '1', '4', '2019-02-18 17:39:09', '2019-02-18 17:39:09');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '自增ID',
  `login_name` varchar(50) NOT NULL COMMENT '登录名（用户邮箱，唯一）',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `description` varchar(255) default NULL COMMENT '描述信息',
  `state` int(2) default NULL COMMENT '用户状态： 1：启用，0：禁用',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `idx_unique` USING BTREE (`login_name`),
  KEY `idx_state` USING BTREE (`state`),
  KEY `idx_createtime` USING BTREE (`create_time`),
  KEY `idx_updatetime` USING BTREE (`update_time`),
  KEY `idx_user_password` USING BTREE (`login_name`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin@126.com', 'admin', '3931MUEQD1939MQMLM4AISPVNE', '系统管理员，拥有全部权限', '1', '2018-10-13 19:48:17', '2019-02-14 15:43:01');
INSERT INTO `sys_user` VALUES ('2', 'test@126.com', 'test', '3931MUEQD1939MQMLM4AISPVNE', '', '0', '2019-01-31 14:56:42', '2019-02-14 15:44:14');
INSERT INTO `sys_user` VALUES ('11', 'jyy@126.com', 'jyy', '15S0M42QJF104H8TMCUQ6GPKEJ', '', '1', '2019-02-08 17:38:40', '2019-02-14 14:25:53');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL auto_increment,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `idx_role_user` USING BTREE (`user_id`,`role_id`),
  KEY `idx_role` USING BTREE (`role_id`),
  KEY `idx_user` USING BTREE (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('30', '11', '3', '2019-02-09 19:05:33', '2019-02-09 19:05:33');
INSERT INTO `sys_user_role` VALUES ('31', '11', '1', '2019-02-09 19:05:33', '2019-02-09 19:05:33');
INSERT INTO `sys_user_role` VALUES ('34', '1', '3', '2019-02-14 15:43:01', '2019-02-14 15:43:01');
INSERT INTO `sys_user_role` VALUES ('35', '1', '1', '2019-02-14 15:43:01', '2019-02-14 15:43:01');
INSERT INTO `sys_user_role` VALUES ('36', '2', '4', '2019-02-14 15:44:14', '2019-02-14 15:44:14');

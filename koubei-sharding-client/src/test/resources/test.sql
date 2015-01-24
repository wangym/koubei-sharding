CREATE DATABASE `shard0`;

USE `shard0`;

/*Table structure for table `main0` */

DROP TABLE IF EXISTS `main0`;

CREATE TABLE `main0` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main1` */

DROP TABLE IF EXISTS `main1`;

CREATE TABLE `main1` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main2` */

DROP TABLE IF EXISTS `main2`;

CREATE TABLE `main2` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main3` */

DROP TABLE IF EXISTS `main3`;

CREATE TABLE `main3` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main4` */

DROP TABLE IF EXISTS `main4`;

CREATE TABLE `main4` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE DATABASE `shard1`;

USE `shard1`;

/*Table structure for table `main0` */

DROP TABLE IF EXISTS `main0`;

CREATE TABLE `main0` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main1` */

DROP TABLE IF EXISTS `main1`;

CREATE TABLE `main1` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main2` */

DROP TABLE IF EXISTS `main2`;

CREATE TABLE `main2` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main3` */

DROP TABLE IF EXISTS `main3`;

CREATE TABLE `main3` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main4` */

DROP TABLE IF EXISTS `main4`;

CREATE TABLE `main4` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE DATABASE `shard2`;

USE `shard2`;

/*Table structure for table `main0` */

DROP TABLE IF EXISTS `main0`;

CREATE TABLE `main0` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main1` */

DROP TABLE IF EXISTS `main1`;

CREATE TABLE `main1` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main2` */

DROP TABLE IF EXISTS `main2`;

CREATE TABLE `main2` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main3` */

DROP TABLE IF EXISTS `main3`;

CREATE TABLE `main3` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main4` */

DROP TABLE IF EXISTS `main4`;

CREATE TABLE `main4` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE DATABASE `shard3`;

USE `shard3`;

/*Table structure for table `main0` */

DROP TABLE IF EXISTS `main0`;

CREATE TABLE `main0` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main1` */

DROP TABLE IF EXISTS `main1`;

CREATE TABLE `main1` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main2` */

DROP TABLE IF EXISTS `main2`;

CREATE TABLE `main2` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main3` */

DROP TABLE IF EXISTS `main3`;

CREATE TABLE `main3` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `main4` */

DROP TABLE IF EXISTS `main4`;

CREATE TABLE `main4` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL,
  `name` varchar(50) collate utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `modified` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


# Sofaker
Sofaker旅行助手
-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- 主机: localhost
-- 生成日期: 2015 年 06 月 14 日 09:31
-- 服务器版本: 5.0.51
-- PHP 版本: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- 数据库: `softer`
-- 

-- --------------------------------------------------------

-- 
-- 表的结构 `message`
-- 

CREATE TABLE `message` (
  `mid` int(11) NOT NULL auto_increment,
  `uid` varchar(25) NOT NULL,
  `date` date NOT NULL,
  `sexneed` varchar(3) NOT NULL,
  `room` varchar(3) NOT NULL,
  `state` tinyint(1) NOT NULL,
  PRIMARY KEY  (`mid`),
  KEY `uid` (`uid`,`sexneed`,`room`,`state`)
) ENGINE=MyISAM DEFAULT CHARSET=gb2312 AUTO_INCREMENT=1 ;

-- 
-- 导出表中的数据 `message`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `user`
-- 

CREATE TABLE `user` (
  `uid` varchar(25) NOT NULL,
  `name` varchar(45) NOT NULL,
  `idnum` varchar(18) NOT NULL,
  `add1` varchar(256) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `age` int(11) NOT NULL,
  `add2` text NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY  (`uid`),
  KEY `add1` (`add1`,`age`)
) ENGINE=MyISAM DEFAULT CHARSET=big5;

-- 
-- 导出表中的数据 `user`
-- 

INSERT INTO `user` VALUES ('123', '123', '123', '123', '123', '123', 0, 123, '123', '123');
INSERT INTO `user` VALUES ('456', '456', '456', '456', '456', '456', 0, 456, '456', '456');

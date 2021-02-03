FROM docker.artifactory.tools.digital.engie.com/ubuntu:18.04
#------------------------------------------------------------------------------
# File Name : Dockerfile
# Author : Naomi De Leon (naomi.deleon@globant.com)
# Creation Date : 2021/02/02
# Version : 0.1
# Top : com
# Company : engie
# Bu : Test
# Be : Test
# Project : Test
# Service Provider : Test
# Description : Dockerfile for the project testing
# Updates history :
# -------+------------+-----------------+--------------------------------------
# Version| Date | Author | Description
# -------+------------+-----------------+--------------------------------------
# | | |
#------------------------------------------------------------------------------
#--------#
# Labels #
#--------#
# Name artifact
LABEL top="com" \
company="engie" \
bu="Test" \
be="Test" \
project="Test" \
service_provider="Test"
# Components
# ----------------------------- #
# Install necessary components #
# ----------------------------- #
RUN echo "===> Installing necessary components" && \
apt-get update && \
apt-get install -y curl wget zip jq vim
#------------------------#
# Install Open JDK & Git #
#------------------------#
RUN apt-get update
RUN echo "===> Installing openjdk-8 for Jenkins connection and git" && \
apt-get install -y openjdk-8-jdk &&\
apt-get install -y git
#-----------END DOCKERFILE--------------#

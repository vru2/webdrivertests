FROM cleartrip/javabase:selenium_mail_GC_109_FF_102
MAINTAINER "MallikarunaVeepuru" <veepuru.mallikarjuna@cleartrip.com>
WORKDIR /opt/app
ENV NLS_LANG="AMERICAN_AMERICA.UTF8"
ENV LC_ALL="en_US.UTF-8"
RUN mkdir -p /opt/app/logs
COPY java_supervisord.conf /etc/supervisord.conf
RUN yum update
RUN yum install -y maven
ADD . /opt/app
CMD ["/usr/bin/supervisord"]
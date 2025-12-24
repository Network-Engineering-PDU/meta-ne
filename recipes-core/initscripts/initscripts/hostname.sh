#!/bin/sh
### BEGIN INIT INFO
# Provides:          hostname
# Required-Start:
# Required-Stop:
# Default-Start:     S
# Default-Stop:
# Short-Description: Set hostname based on /etc/hostname
### END INIT INFO

if [[ -f /home/root/hostname ]]; then
	HOSTNAME=/home/root/hostname
else
	HOSTNAME=/etc/hostname
fi

hostname -b -F $HOSTNAME 2> /dev/null
if [ $? -eq 0 ]; then
	exit
fi

# Busybox hostname doesn't support -b so we need implement it on our own
if [ -f $HOSTNAME ];then
	hostname `cat $HOSTNAME`
else
	hostname localhost
fi

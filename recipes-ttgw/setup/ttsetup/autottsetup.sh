#!/bin/bash
### BEGIN INIT INFO
# Provides: ttsetup
# Required-Start:
# Required-Stop:
# Default-Start:     S
# Default-Stop:
### END INIT INFO

AUTO_FILE=/home/root/.auto
LOG_FILE=/var/log/autottsetup.log

[ -f $AUTO_FILE ] && exit 0

export HOME=/home/root

/usr/bin/ttsetup.sh --auto > $LOG_FILE 2>&1

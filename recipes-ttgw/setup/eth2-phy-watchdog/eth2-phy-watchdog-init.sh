#!/bin/bash
### BEGIN INIT INFO
# Provides: eth2phywatchdog
# Required-Start:
# Required-Stop:
# Default-Start:     S
# Default-Stop:
### END INIT INFO

# Launches the ETH2 PHY watchdog loop (/usr/sbin/eth2-phy-watchdog.sh) in the
# background so boot isn't blocked; the loop itself decides whether this
# board is affected (cm_boardv2) and exits immediately if not.

nohup /usr/sbin/eth2-phy-watchdog.sh >/var/log/eth2-phy-watchdog.log 2>&1 &

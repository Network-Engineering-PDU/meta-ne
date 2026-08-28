#!/bin/bash
# ETH2 (Linux eth0, PHYAD0/fec1, ADIN1300) takes 25-40s to negotiate gigabit
# on the cm_boardv2 hardware revision (external BT module removed), and can
# get stuck with no carrier after a link flap until its advertised modes are
# reset. ETH1 (eth1, PHYAD1/fec2) is unaffected; cm_boardv1 (has the BT
# module) is also unaffected and must be left alone.
#
# A one-time boot-time ethtool call is not enough: any later interface
# down/up (NetworkManager reconnect, cable replug) silently resets ETH2's
# advertised modes back to the hardware default (gigabit included), which
# reintroduces the slow/stuck negotiation. This watchdog re-applies the
# 10/100-only restriction and forces a fresh negotiation attempt whenever it
# detects gigabit has crept back into ETH2's advertised set.

TTVERSION_FILE=/etc/ttversion
AFFECTED_BOARD="cm_boardv2"
ETH2_IFACE=eth0
ETH2_ADVERTISE=0x00f
POLL_INTERVAL=5

is_affected_board () {
	[ -f "$TTVERSION_FILE" ] && grep -q "^BOARD=${AFFECTED_BOARD}$" "$TTVERSION_FILE"
}

is_affected_board || exit 0

while true; do
	if [ -e "/sys/class/net/${ETH2_IFACE}" ]; then
		if ethtool "$ETH2_IFACE" 2>/dev/null | grep -A6 "Advertised link modes" | grep -q "1000baseT"; then
			ethtool -s "$ETH2_IFACE" advertise ${ETH2_ADVERTISE} autoneg on 2>/dev/null
			ethtool -r "$ETH2_IFACE" 2>/dev/null
		fi
	fi
	sleep ${POLL_INTERVAL}
done

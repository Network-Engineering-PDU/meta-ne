# -*- mode: Conf; -*-
SUMMARY = "Watchdog restricting ETH2 (eth0) advertised PHY speeds to 10/100 on affected cm_boardv2 hardware"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "bash ethtool"
inherit update-rc.d

SRC_URI += " \
	file://eth2-phy-watchdog.sh \
	file://eth2-phy-watchdog-init.sh \
"

do_install() {
	install -d ${D}${sbindir}
	install -m 755 ${WORKDIR}/eth2-phy-watchdog.sh ${D}${sbindir}/eth2-phy-watchdog.sh

	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/eth2-phy-watchdog-init.sh ${D}${sysconfdir}/init.d/eth2-phy-watchdog-init.sh
}

PACKAGES = "${PN}"
INITSCRIPT_NAME = "eth2-phy-watchdog-init.sh"
INITSCRIPT_PARAMS = "start 04 5 ."

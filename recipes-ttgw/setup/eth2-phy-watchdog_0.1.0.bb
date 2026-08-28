# -*- mode: Conf; -*-
SUMMARY = "Watchdog restricting ETH2 (eth0) advertised PHY speeds to 10/100 on affected cm_boardv2 hardware"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "bash ethtool"
inherit systemd

SRC_URI += " \
	file://eth2-phy-watchdog.sh \
	file://eth2-phy-watchdog.service \
"

SYSTEMD_SERVICE_${PN} = "eth2-phy-watchdog.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install() {
	install -d ${D}${sbindir}
	install -m 755 ${WORKDIR}/eth2-phy-watchdog.sh ${D}${sbindir}/eth2-phy-watchdog.sh

	install -d ${D}${systemd_unitdir}/system
	install -m 644 ${WORKDIR}/eth2-phy-watchdog.service ${D}${systemd_unitdir}/system/eth2-phy-watchdog.service
}

FILES_${PN} += "${systemd_unitdir}/system/eth2-phy-watchdog.service"

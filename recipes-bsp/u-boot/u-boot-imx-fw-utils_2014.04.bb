# Copyright (C) 2016 Robert Lehmann <robert.lehmann@sitec-systems.de>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "U-Boot bootlader fw_printenv/setenv utilities"
HOMEPAGE = "http://www.sitec-systems.de"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"
SECTION = "base"

FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot-imx:"
SRCBRANCH = "imx_v2014.04_3.14.28_1.0.0_ga"
UBOOT_SRC ?= "git://git.freescale.com/imx/uboot-imx.git;protocol=git"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
SRCREV = "88123ea911e133724cbe738c2b0517fa470592c0"
S = "${WORKDIR}/git"

PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6)"

inherit insane
inherit uboot-config

INSANE_SKIP_${PN} = "already-stripped"

SRC_URI += "file://0001-Add-initial-support-for-S-Core.patch"
SRC_URI += "file://0002-Add-some-optimization-at-the-RAM-initialisation.patch"
SRC_URI += "file://0003-Clean-up-and-add-some-customizations-which-are-hardw.patch"
SRC_URI += "file://0004-Clean-up-and-do-some-hardware-customization.patch"
SRC_URI += "file://0005-SCore-Add-support-for-SPI-boot.patch"
SRC_URI += "file://0006-S-Core-Add-support-for-SPI-NOR-boot.patch"
SRC_URI += "file://0007-S-Core-Add-support-for-NAND-and-SPI-NOR-Flash.patch"
SRC_URI += "file://0008-S-Core-Clean-up-U-Boot-enviroment.patch"
SRC_URI += "file://0009-S-Core-imximage-Add-boot-options.patch"
SRC_URI += "file://0010-S-Core-Add-init-of-second-SD-interface.patch"
SRC_URI += "file://0011-S-Core-boards.cfg-Add-Configuration-for-SPI-NOR-boot.patch"
SRC_URI += "file://0012-S-Core-Fix-issues-for-spi-nor-access.patch"
SRC_URI += "file://0013-S-Core-Fix-some-issues-in-the-U-Boot-environment.patch"
SRC_URI += "file://0014-S2-Add-defined-state-for-some-gpios.patch"
SRC_URI += "file://0015-boards.cfg-Add-a-S2-only-configuration.patch"
SRC_URI += "file://0016-S2-Add-low-state-for-kill_main_pwr-gpio.patch"
SRC_URI += "file://0017-S2-Add-defined-state-for-several-ctrl-gpios.patch"
SRC_URI += "file://0018-S-Core-Add-configuration-for-RMII-interface.patch"
SRC_URI += "file://0019-S-Core-Add-Pin-Mux-and-Config-for-ENET2-interface.patch"
SRC_URI += "file://0020-score-env-Add-possiblity-to-boot-an-alternative-root.patch"
SRC_URI += "file://fw_env.config"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${CC}"'

do_compile() {
    oe_runmake ${UBOOT_MACHINE}
    oe_runmake env
}

do_install() {
    install -d ${D}${bindir}/
    install -d ${D}${sysconfdir}/
    install -m 0755 ${S}/tools/env/fw_printenv ${D}${bindir}/fw_printenv
    install -m 0755 ${S}/tools/env/fw_printenv ${D}${bindir}/fw_setenv
    install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}
}

FILES_${PN} += "${sysconfdir}/* ${bindir}/*"



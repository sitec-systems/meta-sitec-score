# Copyright (C) 2013, 2014 Freescale Semiconductor

DESCRIPTION = "Bootloader for i.MX platforms"
require recipes-bsp/u-boot/u-boot.inc


PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "imx_v2014.04_3.14.28_1.0.0_ga"
UBOOT_SRC ?= "git://git.freescale.com/imx/uboot-imx.git;protocol=git"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
SRCREV = "88123ea911e133724cbe738c2b0517fa470592c0"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
LOCALVERSION = "-1.0.0-score"
PR="r9"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

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
SRC_URI += "file://0021-score-Add-panic-timeout-to-kernel-parameters.patch"
SRC_URI += "file://0022-score-Add-add_args-variable-to-nandargs.patch"
SRC_URI += "file://0023-S-Core-Add-boot-for-alternativ-kernel-dtb.patch"
SRC_URI += "file://0024-mx6sx_pins-Add-SION-configuration-for-REF_CLK2.patch"
SRC_URI += "file://0025-S-Core-Fix-pinmux-for-ENET2-and-activate-clock.patch"
SRC_URI += "file://0026-S-Core-Activate-score-networking.patch"


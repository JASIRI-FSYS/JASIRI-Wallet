# The JASIRI Wallet

This is a fork of the official Algorand Wallet with more customization to fit JASIRI Wallet project requirements

The Algorand Team has done excellent work in their design and implementation of their wallet, with nuanced attention to high-level security. The JASIRI Team just seeks to build off their original implementation and add specific accessibility features. Note that the JASIRI Wallet and the Algorand Wallet are two very different projects with different goals and different teams.  

JASIRI is a project in the Algorand Ecosystem

### Customized Features

- Offline toggle mode - offline toggle mode enables offline sending of ALGOs, and $JASIRI-pesa Assets using Hover's USSD and Africa's Talking APIs with customized Middleware[Note: Should also include any Layer-1 Assets verified]
- Verified $JASIRI-pesa Asset as core asset
- Easy ability to access dapps on the JASIRI Ecosystem[Algorand-compatible dapps built using Reach or bare TEAL/PyTeal] on the fly

### Pending Features(Arranged in order of priority)
1. How do we enable sending ALGOs and JASIRI-pesa Assets offline?
   - We need to integrate Hover's USSD[See: https://www.usehover.com/] into the Android Version and then get
     USSD codes to test and integrate using Africa's Talking APIs[See: https://africastalking.com/]

2. We need to customize the Wallet to include JASIRI's Logo, theming and Graphic Designs

3. We need to only enable verified assets by the JASIRI Team, now it is only ALGOs, and $JASIRI-pesa Asset


## Building
For instructions on how to build the applications in this repo, see [BUILDING.md](./BUILDING.md).

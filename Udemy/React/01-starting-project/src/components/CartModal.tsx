import { forwardRef, useImperativeHandle, useRef } from "react";
import { createPortal } from "react-dom";

import Cart from "./Cart.js";

export interface CartModalHandle {
  open: () => void;
}
export interface CartModalProps {
  title: string;
  actions: React.ReactNode;
}
const CartModal = forwardRef<CartModalHandle, CartModalProps>(function Modal(
  { title, actions },
  ref
) {
  const dialog = useRef<HTMLDialogElement>(null);

  useImperativeHandle(
    ref,
    () => {
      return {
        open: () => {
          dialog.current?.showModal();
        },
      };
    },
    []
  );

  return createPortal(
    <dialog id="modal" ref={dialog}>
      <h2>{title}</h2>
      <Cart  />
      <form method="dialog" id="modal-actions">
        {actions}
      </form>
    </dialog>,

    document.getElementById("modal")!
  );
});

export default CartModal;

import MainProps from './props/MainProps';
function Main({ children }: MainProps) {
    return (
        <>
            <main>
                {children}
            </main>
        </>
    )
}
export default Main;